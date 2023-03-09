package com.example.Authentication.repository;

import com.example.Authentication.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<user,Integer> {
    @Query(value = "SELECT * FROM user WHERE username = ?1", nativeQuery = true)
    user findUsersByUsername(String username);
}