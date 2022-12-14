package fiveman.hotelservice.entities;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "devices")
public class Device implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6208328601953313129L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(required = true)
    private Long id;
    
    private String name;
    
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    private Brand brand;

    @ManyToOne(fetch = FetchType.EAGER)
    private Hotel hotel;

}
