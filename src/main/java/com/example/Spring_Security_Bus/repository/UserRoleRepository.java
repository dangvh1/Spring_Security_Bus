package com.example.Spring_Security_Bus.repository;

import com.example.Spring_Security_Bus.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
}
