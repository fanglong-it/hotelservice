package fiveman.hotelservice.service;

import fiveman.hotelservice.entities.Role;
import fiveman.hotelservice.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    String addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
    String signin(String username, String password);
    String signup(User user);
    User whoami(HttpServletRequest request);
    String refresh(String username);
}
