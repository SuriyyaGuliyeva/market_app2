package com.project.market_app.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UpdateProductDto {
    private Long id;
    private String name;
    private BigDecimal balance;
    private BrandInfoDto brandInfo;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private String barcode;
}
