package com.project.market_app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
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

    private LocalDateTime orderDate;
    private BigDecimal totalPrice;
    private BigDecimal totalDiscount;
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
