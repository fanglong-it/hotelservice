package fiveman.hotelservice.service;

import fiveman.hotelservice.entities.Brand;
import fiveman.hotelservice.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {
    @Autowired
    BrandRepository brandRepository;

    public Brand getBrandById(long id){
        return brandRepository.getReferenceById(id);
    }


}
