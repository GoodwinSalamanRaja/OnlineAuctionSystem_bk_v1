package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Product;
import com.example.demo.model.UserRegister;

public interface UserRegisterService {
   ResponseEntity<?> setDetails(UserRegister register);
   UserRegister checkUsername(String username);
   List<UserRegister> getFiveUser(int size);
   void deleteUser(int id);
   List<UserRegister> getUserBySearch(String username);
   UserRegister getUser(int id);
   UserRegister updateUser(int id, UserRegister userData);
   UserRegister getUserWithBidding(int userId);
   List<UserRegister> userWithBidddingDetails(int size);
   List<UserRegister> serachUserWithBidddingDetails(String name);
}
