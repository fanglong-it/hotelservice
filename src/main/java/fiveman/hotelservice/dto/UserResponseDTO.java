package fiveman.hotelservice.dto;

import fiveman.hotelservice.entities.Role;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Collection;
import java.util.List;

@Data
public class UserResponseDTO {
    @ApiModelProperty(position = 0)
    private Integer id;
    @ApiModelProperty(position = 1)
    private String username;
    @ApiModelProperty(position = 2)
    private String email;
    @ApiModelProperty(position = 3)
    Collection<Role> roles;
}
