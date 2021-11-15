package com.restapi.usersmanagement.service;

import com.restapi.usersmanagement.controller.UserRoleController;
import com.restapi.usersmanagement.model.UserRole;
import com.restapi.usersmanagement.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

@Service
public class UserRoleService {
    Logger logger = Logger.getLogger(UserRoleController.class.getName());
    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<UserRole> getUserRolesByUserIdAndUnitId(int userId, int unitId) {
        return userRoleRepository.findAllByUserIdAndUnitId(userId, unitId);
    }

    public UserRole getUserRoleById(int id) {
        return userRoleRepository.getById(id);
    }

    public List<UserRole> getValidUserRolesByUserIdAndUnitIdAtAGivenTime(int userId, int unitId, LocalDateTime givenTimePoint) {
        return userRoleRepository.findAllByUserIdAndUnitIdAndValidFromIsBefore(userId, unitId, givenTimePoint);
    }

    public void deleteUserRole(int id, int version) {
        UserRole userRole = getUserRoleById(id);
        if (userRole == null) {
            logger.info(String.format("UserRole with id: %s does not exist.", id));
        } else if (userRole.getVersion() == version) {
            userRoleRepository.deleteById(id);
            logger.info(String.format("UserRole with id: %s was successfully deleted.", id));
        } else {
            logger.info(String.format("UserRole with id: %s can not be deleted because of version mismatch.", id));
        }
    }
}
