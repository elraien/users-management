package com.restapi.usersmanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class BaseDTO {
    @NotNull
    private int version;

    @NotBlank(message = "Name is a mandatory field.")
    private String name;
}
