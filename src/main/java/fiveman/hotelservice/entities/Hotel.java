package fiveman.hotelservice.entities;


import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "hotel")
public class Hotel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String phoneNumber;
    private String description;
    private String longtidude;
    private String latitude;
    @OneToMany(mappedBy = "hotel", targetEntity = Device.class)
    private Set<Device> devices;

    @ManyToMany(targetEntity = Location.class)
    Set<Location> locations;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = ServiceProvider.class)
    private Set<ServiceProvider> serviceProviders;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Category.class)
    private Category category;

}
