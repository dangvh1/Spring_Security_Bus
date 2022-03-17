package com.example.Spring_Security_Bus.repository;

import com.example.Spring_Security_Bus.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {
    Users findUsersByUsername(String Username);
}
