package com.example.Spring_Security_Bus.repository;

import com.example.Spring_Security_Bus.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
