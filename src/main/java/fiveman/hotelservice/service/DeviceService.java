package fiveman.hotelservice.service;

import fiveman.hotelservice.entities.Device;
import fiveman.hotelservice.exception.AppException;
import fiveman.hotelservice.exception.GlobalExceptionHandler;
import fiveman.hotelservice.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService{

    @Autowired
    DeviceRepository deviceRepository;

    public List<Device> getDevices(){
        return deviceRepository.findAll();
    }

    public List<Device> getDevicesByBrandId(long id){
        return deviceRepository.findDeviceByBrand_Id(id);
    }

    public ResponseEntity<Device> getDevice(long id){
        if(deviceRepository.findDeviceById(id) == null){
             throw new AppException(HttpStatus.NOT_FOUND.value(), "Not found id = "+id);
        }
        return ResponseEntity.ok(deviceRepository.findDeviceById(id));
    }
    public boolean saveDevice(Device device){
        deviceRepository.save(device);
        if(deviceRepository.getReferenceById(device.getId()) != null){
            return true;
        }
        return false;
    }

    public boolean deleteDevice(long id){
        return deviceRepository.deleteDeviceById(id);
    }




}
