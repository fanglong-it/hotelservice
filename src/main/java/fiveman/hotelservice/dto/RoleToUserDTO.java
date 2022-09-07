package fiveman.hotelservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoleToUserDTO {
    private String username;
    private String rolename;
}
