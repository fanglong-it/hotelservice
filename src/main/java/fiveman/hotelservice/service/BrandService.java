package fiveman.hotelservice.service;

import fiveman.hotelservice.entities.Brand;
import fiveman.hotelservice.entities.Device;

import java.util.List;

public interface BrandService {
	Brand getBrandById(long id);
	List<Brand> findAllProduct(int PAGE_INDEX, int PAGE_SIZE);
	boolean addBrand(Device device);
	boolean deleteBrand(long id);
}
