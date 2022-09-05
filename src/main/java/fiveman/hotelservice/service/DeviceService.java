package fiveman.hotelservice.service;

import java.util.List;

import fiveman.hotelservice.entities.Device;

public interface DeviceService {
	 List<Device> getDevices();
	 List<Device> getDevicesByBrandId(long id);
	 Device getDevice(long id);
	 boolean addDevice(Device device);
	 boolean deleteDevice(long id);
}
