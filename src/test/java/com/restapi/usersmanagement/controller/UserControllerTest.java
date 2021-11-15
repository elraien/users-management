package com.restapi.usersmanagement.controller;

import com.restapi.usersmanagement.model.User;
import com.restapi.usersmanagement.service.UserService;
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
class UserControllerTest {
    @InjectMocks
    UserController userController;

    @Mock
    UserService userService;

    @Test
    void testGetAllUsers() {
        // Prepare
        User user1 = new User();
        User user2 = new User();
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        when(userService.getAllUsers()).thenReturn(users);

        // Perform
        List<User> actualResult = userController.getAllUsers();

        // Verify
        assertThat(actualResult).isNotEmpty();
        assertThat(actualResult.size()).isEqualTo(2);
    }
}