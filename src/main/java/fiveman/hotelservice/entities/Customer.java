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
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private int gender;
    private String phoneNumber;
    private String identityPapers;
    private String email;
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Booking.class)
    private Set<Booking> bookings;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Bill.class)
    private Set<Bill> bills;
}
