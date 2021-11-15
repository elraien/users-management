package com.restapi.usersmanagement.controller;

import com.restapi.usersmanagement.dto.UserDTO;
import com.restapi.usersmanagement.mapper.UserMapper;
import com.restapi.usersmanagement.model.User;
import com.restapi.usersmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.Min;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class UserController {
    Logger logger = Logger.getLogger(UserController.class.getName());
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/users")
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(value = "/users")
    ResponseEntity<Object> createUser(@RequestBody UserDTO userDTO) {
        User user = userMapper.toUserEntity(userDTO);
        User savedUser = userService.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/users/{id}")
    ResponseEntity deleteUser(@PathVariable("id") @Min(1) int id,
                              @RequestParam int version) {
        userService.deleteUser(id, version);
        User deleterUser = userService.findUserById(id);
        if (deleterUser == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping(path = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateUser(@PathVariable int id,
                                        @RequestBody User patchUser) {
        userService.updateUser(id, patchUser);
        return ResponseEntity.ok("resource userName updated");
    }

    @GetMapping(value = "/validusers")
    ResponseEntity<List<User>> getValidUsersAtSpecificUnit(@RequestParam int unitId,
                                                           @RequestParam("datetime")
                                                           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime givenTime) {
        var result = userService.findUsersWithValidUserRoleInAUnit(unitId, givenTime);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/users/userroles")
    ResponseEntity<List<User>> getUsersAndUserRolesInAUnit(@RequestParam int unitId) {
        var result = userService.findUsersAndUserRolesInAUnit(unitId);
        return ResponseEntity.ok(result);
    }
}