package com.restapi.usersmanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class UserRoleDTO {
    @NotNull
    private int version;
    @NotNull
    private int userId;
    @NotNull
    private int unitId;
    @NotNull
    private int roleId;
    private LocalDateTime validFrom;
    private LocalDateTime validTo;
}
