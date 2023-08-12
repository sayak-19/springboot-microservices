package com.example.todo.repository;

import com.example.todo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    /*@Query("SELECT u FROM User u where u.name = :name")
    User findByUserName(@Param("name") String name);*/

    Optional<User> findByUsername(String name);

    Boolean existsByEmail(String email);

    Optional<User> findByUsernameOrEmail(String name, String email);
}
