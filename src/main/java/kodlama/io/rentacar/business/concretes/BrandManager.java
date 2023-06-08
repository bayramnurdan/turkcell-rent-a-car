package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.BrandService;
import kodlama.io.rentacar.business.dto.requests.create.CreateBrandRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateBrandRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateBrandResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllBrandsResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetBrandResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdateBrandResponse;
import kodlama.io.rentacar.business.rules.BrandBusinessRules;
import kodlama.io.rentacar.entities.Brand;
import kodlama.io.rentacar.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
private final BrandRepository repository;
private final ModelMapper mapper;
private final BrandBusinessRules rules;


    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = repository.findAll();
        return  brands
                .stream()
                .map(brand -> mapper.map(brand, GetAllBrandsResponse.class))
                .toList();
    }

    @Override
    public GetBrandResponse getById(int id) {
        rules.checkIfBrandExists(id);
        Brand brand = repository.findById(id).orElseThrow();
        return mapper.map(brand, GetBrandResponse.class);
    }

    @Override
    public CreateBrandResponse add(CreateBrandRequest request) {
        Brand brand = mapper.map(request, Brand.class);
        brand.setId(0);
        Brand createdBrand = repository.save(brand);
        return mapper.map(createdBrand, CreateBrandResponse.class);
    }

    @Override
    public UpdateBrandResponse update(int id, UpdateBrandRequest request) {
        rules.checkIfBrandExists(id);
        Brand brand = mapper.map(request,Brand.class);
        brand.setId(id);
        repository.save(brand);
        return mapper.map(brand, UpdateBrandResponse.class);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

}