package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserRegister;

@Repository
public interface UserRegisterRepo extends JpaRepository<UserRegister, Integer>{
     boolean existsByUsername(String username);
     UserRegister findByUsername(String username);
}
