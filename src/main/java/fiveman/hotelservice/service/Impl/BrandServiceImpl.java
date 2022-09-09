package fiveman.hotelservice.service.Impl;

import fiveman.hotelservice.entities.Brand;
import fiveman.hotelservice.entities.Device;
import fiveman.hotelservice.exception.AppException;
import fiveman.hotelservice.repository.BrandRepository;
import fiveman.hotelservice.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandRepository brandRepository;

    @Override
    public Brand getBrandById(long id) {
        Optional<Brand> brand = Optional.ofNullable(brandRepository.findById(id).orElse(null));
        if (brand != null) {
            Brand dto = brand.orElseGet(null);
            if (dto == null) {
                throw new AppException(HttpStatus.NOT_FOUND.value(), "Not found id = " + id);
            }
            return dto;
        }
        return null;
    }

    @Override
    public List<Brand> findAllProduct(int PAGE_INDEX, int PAGE_SIZE) {
        Pageable pageable = PageRequest.of(PAGE_INDEX, PAGE_SIZE);
        Page<Brand> brands = brandRepository.findAll(pageable);
        if (brands.isEmpty()) {
            throw new AppException(HttpStatus.NOT_FOUND.value(), "Not found item!");
        } else {
            return brands.getContent();
        }
    }

    @Override
    public boolean addBrand(Device device) {
        return false;
    }

    @Override
    public boolean deleteBrand(long id) {
        return false;
    }

}
