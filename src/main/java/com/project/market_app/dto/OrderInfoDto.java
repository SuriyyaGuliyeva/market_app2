package com.project.market_app.dto;

import com.project.market_app.model.User;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class OrderInfoDto {
    private Long id;
    private LocalDateTime orderDate;
    private BigDecimal totalPrice;
    private BigDecimal totalDiscount;
    private BigDecimal price;
    private Long userId;
}
