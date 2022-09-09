package fiveman.hotelservice.service;

import fiveman.hotelservice.entities.Device;

import java.util.List;

public interface DeviceService {
    List<Device> getDevices();

    List<Device> getDevicesByBrandId(long id);

    Device getDevice(long id);

    boolean addDevice(Device device);

    boolean deleteDevice(long id);
}
