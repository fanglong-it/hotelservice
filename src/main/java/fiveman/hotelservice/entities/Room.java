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
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private boolean status;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = RoomType.class)
    private RoomType roomType;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Bill.class)
    private Set<Bill> bills;
}
