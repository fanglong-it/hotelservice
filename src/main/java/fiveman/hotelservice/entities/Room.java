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
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(required = true)
    private long id;
    private String name;
    private String description;
    private boolean status;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = RoomType.class)
    private RoomType roomType;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Bill.class)
    private List<Bill> bills = new ArrayList<>();
}
