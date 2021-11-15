package com.restapi.usersmanagement.service;

import com.restapi.usersmanagement.model.UserRole;
import com.restapi.usersmanagement.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<UserRole> getAllUserRoles() {
        return userRoleRepository.findAll();
    }

    public List<UserRole> getUserRolesByUserIdAndUnitId(int userId, int unitId) {
        return userRoleRepository.findAllByUserIdAndUnitId(userId, unitId);
    }

    public UserRole getUserRoleById(int id) {
        return userRoleRepository.getById(id);
    }

    public List<UserRole> getValidUserRolesByUserIdAndUnitIdAtAGivenTime(int userId, int unitId, LocalDateTime givenTimePoint) {
        return userRoleRepository.findAllByUserIdAndUnitIdAndValidFromIsBefore(userId, unitId, givenTimePoint);
    }

    public void deleteUserRole(int userRoleId) {
        userRoleRepository.deleteById(userRoleId);
    }
}
