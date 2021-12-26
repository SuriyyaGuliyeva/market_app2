package com.project.market_app.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AddBrandDto {
    @NotBlank(message = "Name cannot be blank")
    private String name;
}
