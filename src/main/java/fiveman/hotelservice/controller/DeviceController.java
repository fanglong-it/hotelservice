package fiveman.hotelservice.controller;


import fiveman.hotelservice.entities.Device;
import fiveman.hotelservice.service.BrandService;
import fiveman.hotelservice.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class DeviceController {


    @Autowired
    DeviceService deviceService;
    @Autowired
    BrandService brandService;


    @GetMapping("/devices")
    List<Device> getDevices(){
        return deviceService.getDevices();
    }

    @GetMapping("/device/{id}")
    ResponseEntity<Device> getDevice(@PathVariable("id") long id){
        return deviceService.getDevice(id);
    }

    @PostMapping("/device")
    ResponseEntity<Device> insertDevice(@RequestBody Device device){

        if(!deviceService.getDevicesByBrandId(device.getBrand().getId()).isEmpty()){
            device.setBrand(brandService.getBrandById(device.getBrand().getId()));
            deviceService.saveDevice(device);
            return deviceService.getDevice(device.getId());
        }else{
            return null;
        }
    }

    @DeleteMapping("/device/{id}")
    Boolean deleteDevice(@PathVariable("id") long id){
        return deviceService.deleteDevice(id);
    }
}
