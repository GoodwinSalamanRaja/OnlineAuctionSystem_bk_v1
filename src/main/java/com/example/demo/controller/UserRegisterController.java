package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserRegister;
import com.example.demo.repo.UserRegisterRepo;
import com.example.demo.service.UserRegisterService;

@RestController
@RequestMapping("/register")
public class UserRegisterController {
	@Autowired
	private UserRegisterService urservice;
	@Autowired
	private UserRegisterRepo urrepo;
    @PostMapping("/set")
    public ResponseEntity<?> setDetails(@RequestBody UserRegister register){
    	ResponseEntity<?> response = urservice.setDetails(register);
    	return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PostMapping("/check")
    public ResponseEntity<?> checkData(@RequestBody UserRegister login){
    	System.out.println(urrepo.existsByUsername(login.getUsername()));
    	if(urrepo.existsByUsername(login.getUsername())) {
    		UserRegister list = urservice.checkUsername(login.getUsername());
    		return ResponseEntity.status(HttpStatus.OK).body(list);
    	}
    	else {
    		ResponseEntity<?> response = ResponseEntity.status(HttpStatus.CONFLICT).body("The username doesnot exist");
    		return ResponseEntity.status(HttpStatus.OK).body(response);
    	}
    	
    }
}
