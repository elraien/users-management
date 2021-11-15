package com.restapi.usersmanagement.controller;

import com.restapi.usersmanagement.model.Role;
import com.restapi.usersmanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping(value="/roles")
    List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }
}
