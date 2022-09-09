package fiveman.hotelservice.entities;


import lombok.*;
import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    @ApiModelProperty(required = true)
    private long id;
    private String name;
    
    @ApiModelProperty(required = true)
    private String username;
    
    @ApiModelProperty(required = true)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Role> roles = new ArrayList<>();

}
