package com.example.jpa1to1.repository;

import com.example.jpa1to1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
