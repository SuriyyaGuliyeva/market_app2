package com.project.market_app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @OneToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="user_id", nullable = false)
    @ToString.Exclude
    private User user;

    @OneToMany
    @JoinColumn(name="order_id")
    @ToString.Exclude
    private List<OrderProduct> orderProducts;
}
