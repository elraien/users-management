package com.restapi.usersmanagement.mapper;
import com.restapi.usersmanagement.dto.BaseDTO;
import com.restapi.usersmanagement.dto.RoleDTO;
import com.restapi.usersmanagement.model.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public Role toRoleEntity(RoleDTO roleDTO) {
        return new Role()
                .setName(roleDTO.getName())
                .setVersion(roleDTO.getVersion());
    }

    public RoleDTO toRoleDTO(Role role) {
        return (RoleDTO) new BaseDTO()
                .setName(role.getName())
                .setVersion(role.getVersion());
    }
}
