package fiveman.hotelservice.entities;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(required = true)
    private long id;
    private String name;
    private String phoneNumber;
    private String description;
    private String longtidude;
    private String latitude;
    @OneToMany(fetch = FetchType.EAGER, targetEntity = Device.class)
    private Set<Device> devices;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Location.class)
    private List<Location> locations = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = ServiceProvider.class)
    private List<ServiceProvider> serviceProviders = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Category.class)
    private Category category;

}
