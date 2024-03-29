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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService pservice;
   @PostMapping("/set")
   public ResponseEntity<?> setProduct(@ModelAttribute Product product,@RequestParam("productImage") MultipartFile image){
	   ResponseEntity<?> products = pservice.setProduct(product,image);
	   System.out.println(product.getName() + product.getCategory() + product.getDescription() + product.getRegprice() + product.getBidprice() + product.getBiddate());
	   return ResponseEntity.status(HttpStatus.OK).body(products);
   }
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<?> deleteProduct(@PathVariable int id){
	   pservice.deleteProduct(id);
	   return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
   }
   @GetMapping("/get/{productId}")
   public ResponseEntity<?> getProduct(@PathVariable int productId){
	   Product product = pservice.getProduct(productId);
	   return ResponseEntity.status(HttpStatus.OK).body(product);
   }
   @PutMapping("/update/{productId}")
   public ResponseEntity<?> updateProduct(@PathVariable int productId,@ModelAttribute Product product,@RequestParam("productImage") MultipartFile image){
	   Product saved = pservice.updateProduct(productId,product,image);
	   return ResponseEntity.status(HttpStatus.OK).body(saved);
   }
   @GetMapping("/getFive/{size}")
   public ResponseEntity<?> getFiveProduct(@PathVariable int size){
	   List<Product> product = pservice.getFiveProduct(size);
	   return ResponseEntity.status(HttpStatus.OK).body(product);
   }
   @GetMapping("/getPage/{page}")
   public ResponseEntity<?> getPage(@PathVariable int page){
	   List<Product> product = pservice.getPage(page);
	   return ResponseEntity.status(HttpStatus.OK).body(product);
   }
   @GetMapping("/getByName/{pageName}")
   public ResponseEntity<?> getByName(@PathVariable String pageName){
	   List<Product> product = pservice.getByName(pageName);
	   return ResponseEntity.status(HttpStatus.OK).body(product);
   }
   @GetMapping("/getBySearch/{productName}")
   public ResponseEntity<?> getProductBySearch(@PathVariable String productName){
	   List<Product> product = pservice.getProductBySearch(productName);
	   return ResponseEntity.status(HttpStatus.OK).body(product);
   }
}
