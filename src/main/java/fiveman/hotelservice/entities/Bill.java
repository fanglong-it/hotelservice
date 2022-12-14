package fiveman.hotelservice.entities;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(required = true)
    private long id;
    private String startDate;
    private String endDate;
    private int total;
    private String guestName;
    private String phoneNumber;
    private String email;
    private String billCode;
    private String paymentMethod;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Booking.class)
    private List<Booking> bookings = new ArrayList<>();

//    @ManyToMany(fetch =FetchType.EAGER, targetEntity = Customer.class)
//    private List<Customer> customers = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Room.class)
    private List<Room> rooms = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Service.class)
    private List<Service> services = new ArrayList<>();


}
