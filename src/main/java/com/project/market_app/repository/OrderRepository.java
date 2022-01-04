package com.project.market_app.repository;

import com.project.market_app.model.Brand;
import com.project.market_app.model.Order;
import com.project.market_app.model.Product;
import com.project.market_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // order info
    @Query(value = "SELECT * FROM marketdb.orders WHERE id=?", nativeQuery = true)
    Order orderInfo(Long id);
}
