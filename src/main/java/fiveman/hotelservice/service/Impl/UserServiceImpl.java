package fiveman.hotelservice.service.Impl;

import fiveman.hotelservice.entities.Role;
import fiveman.hotelservice.entities.User;
import fiveman.hotelservice.exception.AppException;
import fiveman.hotelservice.repository.RoleRepository;
import fiveman.hotelservice.repository.UserRepository;
import fiveman.hotelservice.security.JwtTokenProvider;
import fiveman.hotelservice.service.UserService;
import fiveman.hotelservice.utils.Common;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public User saveUser(User user) {
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findRoleByName(Common.USER));
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        roleRepository.save(role);
        return roleRepository.findRoleByName(role.getName());
    }

    @Override
    public String addRoleToUser(String username, String roleName) {
        if(userRepository.existsByUsername(username)){
            User user = userRepository.findUserByUsername(username);
            Role role = roleRepository.findRoleByName(roleName);
            List<Role> roles = user.getRoles();
            roles.add(role);
            user.setRoles(roles);
            userRepository.save(user);
        }else{
            throw new AppException(HttpStatus.NOT_FOUND.value(), "Can't found username!");
        }

        return username;
    }


    @Override
    public User getUser(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User whoami(HttpServletRequest request) {
            return userRepository.findUserByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(request)));
    }

    public String signin(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            User user = userRepository.findUserByUsername(username);
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
            return jwtTokenProvider.createToken(username, authorities);
        } catch (AuthenticationException e) {
            throw new AppException(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Invalid username/password supplied");
        }
    }

    @Override
    public String signup(User user) {
            if (!userRepository.existsByUsername(user.getUsername())) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                List<Role> roles = new ArrayList<>();
                roles.add(roleRepository.findRoleByName(Common.USER));
                user.setRoles(roles);
                userRepository.save(user);
                Collection<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
                user.getRoles().forEach(role -> {
                    grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
                });
                return jwtTokenProvider.createToken(user.getUsername(), grantedAuthorities);
            } else {
                throw new AppException(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Username is already in use");
            }
    }

    @Override
    public String refresh(String username) {
        User user = userRepository.findUserByUsername(username);
        Collection<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return jwtTokenProvider.createToken(username, grantedAuthorities);
    }
}
