package com.project.market_app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class AddOrderDto {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @ApiModelProperty(required = true, example = "2021-08-20T00:00:00")
    @NotNull(message = "Created date cannot be null")
    private LocalDateTime orderDate;

    @NotNull(message = "Total price cannot be null")
    private BigDecimal totalPrice;

    @NotNull(message = "Total discount cannot be null")
    private BigDecimal totalDiscount;

    @NotNull(message = "Price cannot be null")
    private BigDecimal price;

//    @NotNull(message = "User ID cannot be null")
    private UserInfoDto userInfo;
}
