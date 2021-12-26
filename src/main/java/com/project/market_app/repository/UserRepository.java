package com.project.market_app.repository;

import com.project.market_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // user info
    @Query(value = "select * from marketdb.users where id=?", nativeQuery = true)
    User userInfo(Long id);
}
