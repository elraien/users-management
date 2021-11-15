package com.restapi.usersmanagement.mapper;

import com.restapi.usersmanagement.dto.UserRoleDTO;
import com.restapi.usersmanagement.model.UserRole;
import org.springframework.stereotype.Component;

@Component
public class UserRoleMapper {
    public UserRole toUnitEntity(UserRoleDTO userRoleDTO) {
        if (userRoleDTO == null) {
            return null;
        }
        return new UserRole()
                .setRoleId(userRoleDTO.getRoleId())
                .setUnitId(userRoleDTO.getUnitId())
                .setUserId(userRoleDTO.getUserId())
                .setVersion(userRoleDTO.getVersion())
                .setValidFrom(userRoleDTO.getValidFrom())
                .setValidTo(userRoleDTO.getValidTo());
    }

    public UserRoleDTO toUnitDTO(UserRole userRole) {
        if (userRole == null) {
            return null;
        }
        return new UserRoleDTO()
                .setRoleId(userRole.getRoleId())
                .setUnitId(userRole.getUnitId())
                .setUserId(userRole.getUserId())
                .setVersion(userRole.getVersion())
                .setValidFrom(userRole.getValidFrom())
                .setValidTo(userRole.getValidTo());
    }
}
