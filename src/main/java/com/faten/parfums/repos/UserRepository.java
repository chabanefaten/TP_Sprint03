package com.faten.parfums.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faten.parfums.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}
