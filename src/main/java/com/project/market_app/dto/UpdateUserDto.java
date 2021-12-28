package com.project.market_app.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class UpdateUserDto {
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Password should have at least 8 characters")
    private String password;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Password should have at least 8 characters")
    private String confirmPassword;
}
