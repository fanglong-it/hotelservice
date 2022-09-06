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
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String title;
    private String description;
    private String startTime;
    private String endTime;
    private String organizer;
    private String picture;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Location.class)
    private Location location;

}
