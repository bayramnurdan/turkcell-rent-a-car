package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.CarService;
import kodlama.io.rentacar.business.abstracts.MaintenanceService;
import kodlama.io.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateCarRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateMaintenanceRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetCarResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdateMaintenanceResponse;
import kodlama.io.rentacar.entities.Maintenance;
import kodlama.io.rentacar.entities.enums.State;
import kodlama.io.rentacar.repository.MaintenanceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
public class MaintenanceManager implements MaintenanceService {
    private final MaintenanceRepository repository;
    private final ModelMapper mapper;
    private final CarService carService;




    @Override
    public List<GetAllMaintenanceResponse> getAll() {
        List<Maintenance> maintenances = repository.findAll();
        List<GetAllMaintenanceResponse> response = maintenances
                .stream()
                .map(car -> mapper.map(car, GetAllMaintenanceResponse.class))
                .toList();
        return response;

    }


    @Override
    public GetMaintenanceResponse getById(int id) {
        checkIfMaintenanceExists(id);
        GetMaintenanceResponse response = mapper.map(repository.findById(id), GetMaintenanceResponse.class);
        return response;

    }


    @Override
    public CreateMaintenanceResponse sendToMaintenance(CreateMaintenanceRequest request) {
        checkIfAvailableForMaintenance(request.getCarId());  // araba statei kontrol
        Maintenance maintenance=  mapper.map(request, Maintenance.class);
        repository.save(maintenance);

        UpdateCarRequest car = mapper.map(carService.getById(request.getCarId()), UpdateCarRequest.class);
        car.setState(State.MAINTENANCE);
        carService.update(car.getId(),car);

        CreateMaintenanceResponse response = mapper.map(maintenance, CreateMaintenanceResponse.class);
        return response;
    }


    @Override
    public UpdateMaintenanceResponse updateMaintenanceStatus(UpdateMaintenanceRequest request) {
        Maintenance maintenance=  mapper.map(request, Maintenance.class);
        repository.save(maintenance);
        maintenance.getCar().setState(State.AVAILABLE);
        UpdateMaintenanceResponse response = mapper.map(maintenance, UpdateMaintenanceResponse.class);
        return response;

    }

    @Override
    public void delete(int id) {
        UpdateMaintenanceRequest request =mapper.map(repository.findById(id).get(), UpdateMaintenanceRequest.class);
        updateMaintenanceStatus(request);

    }

    public void checkIfMaintenanceExists(int id){
        repository.findById(id).orElseThrow();
    }

    public void checkIfAvailableForMaintenance(int id){
        GetCarResponse response = carService.getById(id);


        if(response.getState().equals(State.MAINTENANCE) || response.getState().equals(State.RENTED)){
            throw new RuntimeException("Araba  bakım için müsait değil");
        }
    }
}
