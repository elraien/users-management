package com.restapi.usersmanagement.service;

import com.restapi.usersmanagement.exception.EntityNotFoundException;
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

    public void deleteUser(int id, int version) {
        var user = findUserById(id);
        if (user == null) {
            logger.info(String.format("User with id: %s does not exist.", id));
        }

        var userInUserRole = userRoleRepository.findUserRoleByUserId(id);
        if (userInUserRole.isEmpty() && user.getVersion() == version) {
            userRepository.deleteById(id);
            logger.info(String.format("User with id: %s was successfully deleted.", id));
        } else {
            logger.info(String.format("User with id: %s can not be deleted because either userRole is not empty or due to version mismatch.", id));
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

    public void updateUser(int id, User patchUser) {
        User user = findUserById(id);
        if (user == null) {
            throw new EntityNotFoundException("User can not be updated because it does not exist.");
        }
        if (user.getVersion() == patchUser.getVersion()) {
            save(patchUser);
            logger.info(String.format("User with id: %s was successfully updated.", id));
        } else {
            logger.info(String.format("User with id: %s can not be updated because of version mismatch.", id));
        }
    }
}
