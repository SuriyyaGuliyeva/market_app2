package com.project.market_app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany
    @JoinColumn(name="order_id", nullable = false)
    @ToString.Exclude
    private List<Order> orders;
}
