package fiveman.hotelservice.controller;

import fiveman.hotelservice.entities.Role;
import fiveman.hotelservice.request.RoleToUserRequest;
import fiveman.hotelservice.response.CustomResponseObject;
import fiveman.hotelservice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@Api(tags = "Role")
@RequestMapping("/api/v1")
public class RoleController {

    @Autowired
    UserService userService;

    @PostMapping("/role/save")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        return new ResponseEntity<Role>(userService.saveRole(role), HttpStatus.OK);
    }
    
    @PutMapping("/role/setRoleAdmin")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public ResponseEntity<CustomResponseObject> setRoleAdmin(@RequestBody RoleToUserRequest form){
    	 CustomResponseObject result = new CustomResponseObject("add role sucessfully for account " + userService.addRoleToUser(form.getUsername(), form.getRolename()));
         return new ResponseEntity<CustomResponseObject>(result, HttpStatus.OK);
    }


    @PostMapping("/role/addRoleToUser")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${UserController.addRoleToUser}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public ResponseEntity<CustomResponseObject> addRoleToUser(@RequestBody RoleToUserRequest form){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/role/save").toUriString());
        CustomResponseObject result = new CustomResponseObject("add role sucessfully for account " + userService.addRoleToUser(form.getUsername(), form.getRolename()));
        return new ResponseEntity<CustomResponseObject>(result, HttpStatus.OK);
    }

}
