package com.project.market_app.dto;

import com.project.market_app.model.Brand;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Getter
@Setter
public class AddProductDto {
    // private Long id;
    private String name;
    private BigDecimal balance;
    private BrandInfoDto brandInfo;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private String barcode;
    private Boolean deleted;
}
