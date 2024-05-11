package com.faten.parfums.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faten.parfums.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
Role findByRole(String role);
}