package com.project.market_app.repository;

import com.project.market_app.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    // brand info
    @Query(value = "SELECT * FROM marketdb.brands WHERE id=?", nativeQuery = true)
    Brand brandInfo(Long id);
}
