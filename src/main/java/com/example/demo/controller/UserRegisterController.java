package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Product;
import com.example.demo.model.UserRegister;
import com.example.demo.repo.UserRegisterRepo;
import com.example.demo.service.UserRegisterService;

@RestController
@RequestMapping("/user")
public class UserRegisterController {
	@Autowired
	private UserRegisterService urservice;
	@Autowired
	private UserRegisterRepo urrepo;
    @PostMapping("/register")
    public ResponseEntity<?> setDetails(@RequestBody UserRegister register){
    	ResponseEntity<?> response = urservice.setDetails(register);
    	return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PostMapping("/login")
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
    @GetMapping("/getBid/{userId}")
    public ResponseEntity<?> getUserWithBidding(@PathVariable int userId){
       UserRegister user = urservice.getUserWithBidding(userId);
 	   return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    @GetMapping("/getFive/{size}")
    public ResponseEntity<?> getFiveUser(@PathVariable int size){
 	   List<UserRegister> user = urservice.getFiveUser(size);
 	   return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
 	   urservice.deleteUser(id);
 	   return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
    }
    @GetMapping("/getBySearch/{username}")
    public ResponseEntity<?> getUserBySearch(@PathVariable String username){
 	   List<UserRegister> user = urservice.getUserBySearch(username);
 	   return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id){
 	   UserRegister user = urservice.getUser(id);
 	   return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id,@RequestBody UserRegister userData){
 	   UserRegister user = urservice.updateUser(id,userData);
 	   return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    @GetMapping("/userwithbid/{size}")
    public ResponseEntity<?> userWithBidddingDetails(@PathVariable int size){
  	   List<UserRegister> user = urservice.userWithBidddingDetails(size);
  	   return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    @GetMapping("/searchuserwithbid/{name}")
    public ResponseEntity<?> searchUserWithBidddingDetails(@PathVariable String name){
  	   List<UserRegister> user = urservice.serachUserWithBidddingDetails(name);
  	   return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}   
