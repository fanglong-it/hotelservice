package fiveman.hotelservice.entities;

import io.swagger.annotations.ApiModelProperty;
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
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(required = true)
    private long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private int gender;
    private String phoneNumber;
    private String identityPapers;
    private String email;
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Booking.class)
    private List<Booking> bookings = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Bill.class)
    private List<Bill> bills = new ArrayList<>();
}
