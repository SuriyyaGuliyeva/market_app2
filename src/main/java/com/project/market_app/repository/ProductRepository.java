package com.project.market_app.repository;

import com.project.market_app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // product list
    @Query(value = "SELECT * FROM marketdb.products where deleted=0", nativeQuery = true)
    List<Product> productList();

    // product info
    @Query(value = "SELECT * FROM marketdb.products where id=? AND deleted=0", nativeQuery = true)
    Product productInfo(Long id);

    // delete product
    @Modifying
    @Transactional
    @Query(value = "UPDATE marketdb.products SET deleted=1 WHERE id=?", nativeQuery = true)
    void deleteProductById(Long id);
}
