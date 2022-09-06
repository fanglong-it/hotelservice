package fiveman.hotelservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    private long id;
    private String startDate;
    private String endDate;
    private int total;
    private String guestName;
    private String phoneNumber;
    private String emai;
    private String billCode;
    private String paymentMethod;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Booking.class)
    private Set<Booking> bookings;

    @ManyToMany(fetch =FetchType.LAZY, targetEntity = Customer.class)
    private Set<Customer> customers;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Room.class)
    private Set<Room> rooms;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Service.class)
    private Set<Service> services;


}
