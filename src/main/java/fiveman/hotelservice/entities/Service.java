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
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String picture;
    private double price;
    private String description;
    private boolean isExternal;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Category.class)
    private Category category;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Bill.class)
    private Set<Bill> bills;

}
