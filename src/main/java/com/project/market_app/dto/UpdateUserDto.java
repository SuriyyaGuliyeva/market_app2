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

    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Password must be between 8 to 15 characters")
    @Size(min = 8, max = 15)
    private String password;

    @NotNull(message = "Password must be between 8 to 15 characters")
    @Size(min = 8, max = 15)
    private String confirmPassword;
}
