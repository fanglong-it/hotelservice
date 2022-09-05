package fiveman.hotelservice.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import fiveman.hotelservice.entities.Brand;
import fiveman.hotelservice.exception.AppException;
import fiveman.hotelservice.repository.BrandRepository;
import fiveman.hotelservice.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService{

	@Autowired
	BrandRepository brandRepository;
	
	@Override
	public Brand getBrandById(long id) {
		Optional<Brand> brand = Optional.ofNullable(brandRepository.findById(id).orElse(null));
		if(brand != null) {
			Brand dto = brand.orElseGet(null);
			if(dto == null) {
				
//				productResponse res = new productResponse(dto.getProductID(), dto.getProductSKU(), dto.getProductName(), dto.getProductPrice(), dto.getProductWeight(), dto.getProductCartDesc(),
//						dto.getProductShortDesc(), dto.getProductLongDesc(), dto.getProductThumb(), dto.getProductImage(), dto.getProductUpdateDate(), dto.getProductStock(), dto.getProductLive(),
//						dto.getProductUnlimited(), listOption, listOptionGroups);
//				return res;
				throw new AppException(HttpStatus.NOT_FOUND.value(), "Not found id = "+id);   
			}
			return dto;
		}
		return null;
	}
	
}
