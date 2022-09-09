package fiveman.hotelservice.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoleToUserRequest {
    private String username;
    private String rolename;
}
