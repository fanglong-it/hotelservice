package fiveman.hotelservice.entities;


import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Role.class)
    private Collection<Role> roles = new ArrayList<>();
}
