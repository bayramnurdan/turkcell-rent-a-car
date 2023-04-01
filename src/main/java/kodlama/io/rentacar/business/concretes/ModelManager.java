package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.ModelService;
import kodlama.io.rentacar.business.dto.requests.create.CreateModelRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateModelRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateModelResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllModelsResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetModelResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdateModelResponse;
import kodlama.io.rentacar.entities.Model;
import kodlama.io.rentacar.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private final ModelRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = repository.findAll();
        List<GetAllModelsResponse> response = models
                .stream()
                .map(model -> mapper.map(model, GetAllModelsResponse.class))
                .toList();
        return response;
    }

    @Override
    public GetModelResponse getById(int id) {
        checkIfModelExists(id);
        Model model = repository.findById(id).orElseThrow();
        GetModelResponse response = mapper.map(model, GetModelResponse.class);

        return response;
    }

    @Override
    public CreateModelResponse add(CreateModelRequest request) {
        Model model = mapper.map(request, Model.class); // iki sınıftaki field isimlerini eşliyor.
        model.setId(0); //olası hatayı önlemek için, idleri genelde karıştırıyor.
        repository.save(model);
        CreateModelResponse response = mapper.map(model, CreateModelResponse.class);
        return response;
    }

    @Override
    public UpdateModelResponse update(int id, UpdateModelRequest request) {  //TEKRAR BAK
        return null;
    }

    @Override
    public void delete(int id) {

    }

    private void checkIfModelExists(int id){
        if (!repository.existsById(id)) throw new RuntimeException("Böyle bir model mevcut değil.");
    }

}

