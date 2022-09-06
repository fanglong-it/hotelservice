package fiveman.hotelservice.service;

import fiveman.hotelservice.entities.Role;
import fiveman.hotelservice.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();

}
