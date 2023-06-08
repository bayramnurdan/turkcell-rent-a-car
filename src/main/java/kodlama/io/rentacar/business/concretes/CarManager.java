package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.CarService;
import kodlama.io.rentacar.business.dto.requests.create.CreateCarRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateCarRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateCarResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllCarsResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetCarResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdateCarResponse;
import kodlama.io.rentacar.business.rules.CarBusinessRules;
import kodlama.io.rentacar.entities.Car;
import kodlama.io.rentacar.entities.enums.State;
import kodlama.io.rentacar.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private final CarRepository repository;
    private final ModelMapper mapper;
    private final CarBusinessRules rules;

    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> cars = repository.findAll();
        return cars
                .stream()
                .map(car -> mapper.map(car, GetAllCarsResponse.class))
                .toList();
    }
    @Override
    public List<GetAllCarsResponse> getAllByState(String state) {
        List<Car> cars = repository.findAll();
        return cars
                .stream()
                .filter((car)-> car.getState().name().equalsIgnoreCase(state))
                .map(car -> mapper.map(car, GetAllCarsResponse.class))
                .toList();
    }


    @Override
    public GetCarResponse getById(int id) {
        rules.checkIfCarExists(id);
        Car car = repository.findById(id).orElseThrow();
        return mapper.map(car, GetCarResponse.class);
    }


    @Override
    public UpdateCarResponse update(int carId, UpdateCarRequest request){
        rules.checkIfCarExists(carId);
        Car car = mapper.map(request,Car.class);
        car.setId(carId);
        repository.save(car);
        return mapper.map(car, UpdateCarResponse.class);
    }

    @Override
    public CreateCarResponse add(CreateCarRequest request) {
        Car car = mapper.map(request, Car.class);
        car.setId(0);
        car.setState(State.AVAILABLE);
        repository.save(car);
        return mapper.map(car, CreateCarResponse.class);
    }


    @Override
    public void delete(int id) {
        rules.checkIfCarExists(id);
        repository.deleteById(id);
    }

    @Override
    public void changeState(int carId, State state) {
        rules.checkIfCarExists(carId);
        Car car = repository.findById(carId).orElseThrow();
        car.setState(state);
        repository.save(car);
    }

}