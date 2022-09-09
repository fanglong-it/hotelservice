package fiveman.hotelservice.service.Impl;

import fiveman.hotelservice.entities.Device;
import fiveman.hotelservice.exception.AppException;
import fiveman.hotelservice.repository.BrandRepository;
import fiveman.hotelservice.repository.DeviceRepository;
import fiveman.hotelservice.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    BrandRepository brandRepository;

    @Override
    public List<Device> getDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public List<Device> getDevicesByBrandId(long id) {
        return deviceRepository.findDeviceByBrand_Id(id);
    }

    @Override
    public Device getDevice(long id) {
        Optional<Device> device = Optional.ofNullable(deviceRepository.findById(id).orElse(null));
        if (device != null) {
            Device dto = device.orElseGet(null);
            if (dto == null) {

//				productResponse res = new productResponse(dto.getProductID(), dto.getProductSKU(), dto.getProductName(), dto.getProductPrice(), dto.getProductWeight(), dto.getProductCartDesc(),
//						dto.getProductShortDesc(), dto.getProductLongDesc(), dto.getProductThumb(), dto.getProductImage(), dto.getProductUpdateDate(), dto.getProductStock(), dto.getProductLive(),
//						dto.getProductUnlimited(), listOption, listOptionGroups);
//				return res;
                throw new AppException(HttpStatus.NOT_FOUND.value(), "Not found id = " + id);
            }
            return dto;
        }
        return null;
    }

    @Override
    public boolean addDevice(Device device) {
        List<Device> listDevice = deviceRepository.findDeviceByBrand_Id(device.getBrand().getId());
        if (listDevice.isEmpty()) {
            throw new AppException(HttpStatus.NOT_FOUND.value(), "Not found device with brand is: " + device.getBrand().getName());
        }
        device.setBrand(brandRepository.getReferenceById(device.getBrand().getId()));
        deviceRepository.save(device);
        if (deviceRepository.getReferenceById(device.getId()) != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteDevice(long id) {
        Optional<Device> device = Optional.ofNullable(deviceRepository.findById(id).orElse(null));
        if (device != null) {
            Device dto = device.orElseGet(null);
            if (dto != null) {
                deviceRepository.deleteById(id);
                return true;
            }
        }
        return false;
    }
}
