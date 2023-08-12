package com.springboot.springboottransactiondemo.repository;

import com.springboot.springboottransactiondemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u where u.username = :name")
    Optional<User> findByUsername(@Param("name") String name);

   // Optional<User> findByUsername(String username);
}
