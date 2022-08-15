package fiveman.hotelservice;

import fiveman.hotelservice.entities.Device;
import fiveman.hotelservice.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(HotelserviceApplication.class, args);
    }
}
