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
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(required = true)
    private long id;
    private String name;
    private int rating;
    private String address;
    private String longtidude;
    private String latidute;
    private String shortDescription;
    private String description;
    private String picture;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Hotel.class)
    private List<Hotel> hotels = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = LocationType.class)
    private LocationType locationType;

}
