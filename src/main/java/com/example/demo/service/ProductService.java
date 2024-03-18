package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Product;


public interface ProductService {

   ResponseEntity<?> setProduct(Product product,MultipartFile image);
   List<Product> getAllProduct();
   void deleteProduct(int id);
   Product getProduct(int productId);
   Product updateProduct(int productId, Product product, MultipartFile image); 
}
