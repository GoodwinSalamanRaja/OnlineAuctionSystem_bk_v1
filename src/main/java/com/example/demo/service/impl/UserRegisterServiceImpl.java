package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserRegister;
import com.example.demo.repo.UserRegisterRepo;
import com.example.demo.service.UserRegisterService;

@Service
public class UserRegisterServiceImpl implements UserRegisterService{
   @Autowired
   private UserRegisterRepo urrepo;
   @Override
   public ResponseEntity<?> setDetails(UserRegister register) {
	   if(urrepo.existsByUsername(register.getUsername())) {
		   return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
	   }
	   else {
		   UserRegister savedUser = urrepo.save(register);
		   return ResponseEntity.status(HttpStatus.OK).body(savedUser);
	   }
   }
   @Override
   public UserRegister checkUsername(String username) {
	   UserRegister list = urrepo.findByUsername(username);
	   return list;
   }
}
