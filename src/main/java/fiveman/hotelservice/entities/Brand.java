package fiveman.hotelservice.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "brand")
public class Brand implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 321994554501884556L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
