package com.example.demo.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.UserRegister;

public interface UserRegisterService {
   ResponseEntity<?> setDetails(UserRegister register);
   UserRegister checkUsername(String username);
}
