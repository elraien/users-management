package com.restapi.usersmanagement.mapper;

import com.restapi.usersmanagement.dto.BaseDTO;
import com.restapi.usersmanagement.dto.UserDTO;
import com.restapi.usersmanagement.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toUserEntity(UserDTO userDTO) {
        return new User()
                .setName(userDTO.getName())
                .setVersion(userDTO.getVersion());
    }

    public UserDTO toUserDTO(User user) {
        return (UserDTO) new BaseDTO()
                .setName(user.getName())
                .setVersion(user.getVersion());
    }
}
