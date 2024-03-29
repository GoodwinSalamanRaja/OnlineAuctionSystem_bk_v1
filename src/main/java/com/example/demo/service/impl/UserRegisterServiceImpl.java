package com.example.demo.service.impl;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Product;
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
   @Override
   public List<UserRegister> getFiveUser(int size){
	   List<UserRegister> user = urrepo.findAll(PageRequest.of(0, size)).toList();
	   return user;
   }
   @Override
   public void deleteUser(int id) {
	   UserRegister user = urrepo.findById(id).get();
	   urrepo.delete(user);
   }
   @Override
   public List<UserRegister> getUserBySearch(String username){
	   List<UserRegister> user = urrepo.findBySearchingName(username);
	   return user;
   }
   @Override
   public UserRegister getUser(int id) {
	   UserRegister user = urrepo.findById(id).get();
	   return user;
   }
   @Override
   public UserRegister updateUser(int id,UserRegister userData) {
		   UserRegister user = urrepo.findById(id).get();
		   user.setName(userData.getName());
		   user.setUsername(userData.getUsername());
		   user.setEmail(userData.getEmail());
		   user.setPassword(userData.getPassword());
		   UserRegister savedData = urrepo.save(user);
		   return savedData;
   }
   @Override
   public UserRegister getUserWithBidding(int userId){
	   UserRegister user = urrepo.findById(userId).get();
	   return user;
   }
   @Override
   public List<UserRegister> userWithBidddingDetails(int size){
	   List<UserRegister> user = urrepo.findAllWithBiddingsNotNull(PageRequest.of(0, size));
	   return user;
   }
   @Override
   public List<UserRegister> serachUserWithBidddingDetails(String name){
	   List<UserRegister> user = urrepo.findByBid(name);
	   return user;
   }
}
