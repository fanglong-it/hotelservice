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
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String bookingDate;
    private String bookingTime;
    private String arrivalDate;
    private String departureDate;
    private int numAdults;
    private int numChildren;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Customer.class)
    private Set<Customer> customers;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Room.class)
    private Room room;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Problem.class)
    private Set<Problem> problems;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Bill.class)
    private Set<Bill> bills;
}
