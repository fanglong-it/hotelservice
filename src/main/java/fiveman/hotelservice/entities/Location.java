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
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int rating;
    private String address;
    private String longtidude;
    private String latidute;
    private String shortDescription;
    private String description;
    private String picture;

    @ManyToMany(targetEntity = Hotel.class)
    Set<Hotel> hotels;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = LocationType.class)
    private LocationType locationType;

}
