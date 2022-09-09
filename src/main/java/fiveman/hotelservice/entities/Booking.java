package fiveman.hotelservice.entities;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(required = true)
    private long id;
    private String bookingDate;
    private String bookingTime;
    private String arrivalDate;
    private String departureDate;
    private int numAdults;
    private int numChildren;

//    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Customer.class)
//    private List<Customer> customers = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Room.class)
    private Room room;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Problem.class)
    private List<Problem> problems = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Bill.class, mappedBy = "bookings")
    private List<Bill> bills = new ArrayList<>();
}
