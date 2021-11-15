package com.restapi.usersmanagement.service;

import com.restapi.usersmanagement.model.User;
import com.restapi.usersmanagement.repository.UserRepository;
import com.restapi.usersmanagement.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

@Service
public class UserService {
    Logger logger = Logger.getLogger(UserService.class.getName());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        var userInUserRole = userRoleRepository.findUserRoleByUserId(id);
        if (userInUserRole.isEmpty()) {
            userRepository.deleteById(id);
        } else {
            logger.info(String.format("User with id: %s exists in user_role table and therefore can't be deleted.", id));
        }
    }

    public User findUserById(int id) {
        return userRepository.getById(id);
    }

    public List<User> findUsersWithValidUserRoleInAUnit(int unitId, LocalDateTime givenTimePoint) {
        return userRepository.findAllByUnitIdAndValidUserRole(unitId, givenTimePoint);
    }

    public List<User> findUsersAndUserRolesInAUnit(int unitId) {
        return userRepository.findAllByUnitIdAndUserRole(unitId);
    }
}
