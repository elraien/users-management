package com.restapi.usersmanagement.controller;

import com.restapi.usersmanagement.model.Role;
import com.restapi.usersmanagement.service.RoleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoleControllerTest {

    @InjectMocks
    RoleController roleController;

    @Mock
    RoleService roleService;

    @Test
    void testGetAllRoles() {
        // Prepare
        Role role1 = new Role();
        Role role2 = new Role();
        List<Role> roles = new ArrayList<>();
        roles.add(role1);
        roles.add(role2);

        when(roleService.getAllRoles()).thenReturn(roles);

        // Perform
        List<Role> actualResult = roleController.getAllRoles();

        // Verify
        assertThat(actualResult).isNotEmpty();
        assertThat(actualResult.size()).isEqualTo(2);
    }
}