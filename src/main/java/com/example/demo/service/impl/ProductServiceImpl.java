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
import com.example.demo.repo.ProductRepo;
import com.example.demo.service.ProductService;



@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepo prepo;
   @Override
   public ResponseEntity<?> setProduct(Product product,MultipartFile image){
	   if (image.isEmpty()) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please enter a valid ");
		}
	   else {
		   try {
			   byte bytes[] = image.getBytes();
			   UUID uuid = UUID.randomUUID();
			   String uploadsLocation = "C:\\Users\\goodw\\SpringBoot-workspace\\Online_Auction_System\\src\\main\\resources\\uploads\\";
			   String fileLocation = uploadsLocation + uuid + image.getOriginalFilename();
			   java.nio.file.Path path = Paths.get(fileLocation);
			   Files.write(path,bytes);
//			   File file = new File(fileLocation);
			   Product pro = new Product();
			   pro.setName(product.getName());
			   pro.setCategory(product.getCategory());
			   pro.setDescription(product.getDescription());
			   pro.setRegprice(product.getRegprice());
			   pro.setBidprice(product.getBidprice());
			   pro.setBiddate(product.getBiddate());
			   pro.setImage(uuid + image.getOriginalFilename());
			   Product savedProduct = prepo.save(pro);
			   return ResponseEntity.status(HttpStatus.OK).body(savedProduct);
		   }
		   catch(Exception e) {
			   e.printStackTrace();
			   return ResponseEntity.status(HttpStatus.CREATED).body(e.getMessage());
		   }
	   }
   }
   @Override
   public List<Product> getAllProduct(){
	   List<Product> product = prepo.findAll();
	   return product;
   }
   @Override
   public void deleteProduct(int id) {
	   Product product = prepo.findById(id).get();
	   prepo.delete(product);
   }
   @Override
   public Product getProduct(int productId) {
	   Product product = prepo.findById(productId).get();
	   return product;
   }
   @Override
   public Product updateProduct(int productId,Product product,MultipartFile image) {
	   try {
		   byte bytes[] = image.getBytes();
		   UUID uuid = UUID.randomUUID();
		   String uploadLocation = "C:\\Users\\goodw\\SpringBoot-workspace\\Online_Auction_System\\src\\main\\resources\\uploads\\";
		   String fileLocation = uploadLocation + uuid + image.getOriginalFilename();
		   java.nio.file.Path path = Paths.get(fileLocation);
		   java.nio.file.Path p = Files.write(path, bytes);
		   System.out.println(p);
		   System.out.println(productId);
		   System.out.println(product.getName());
		   System.out.println(product.getCategory());
		   System.out.println(product.getRegprice());
		   System.out.println(product.getBidprice());
		   System.out.println(product.getBiddate());
		   System.out.println(uuid + image.getOriginalFilename());
		   Product pro = prepo.findById(productId).get();
		   pro.setId(productId);
		   pro.setName(product.getName());
		   pro.setCategory(product.getCategory());
		   pro.setDescription(product.getDescription());
		   pro.setRegprice(product.getRegprice());
		   pro.setBidprice(product.getBidprice());
		   pro.setBiddate(product.getBiddate());
		   pro.setImage(uuid + image.getOriginalFilename());
		   Product savedProduct = prepo.save(pro);
		   return savedProduct;
	   }
	   catch (Exception e) {
		   e.printStackTrace();
		   return null;
	   }
   }
   @Override
   public List<Product> getFiveProduct(int size){
	   List<Product> product = prepo.findAll(PageRequest.of(0, size)).toList();
	   return product;
   }
   @Override
   public List<Product> getPage(int page){
	   List<Product> product = prepo.findAll(PageRequest.of(page, 4)).toList();
	   return product;
   }
   @Override
   public List<Product> getByName(String pageName){
	   List<Product> product = prepo.findByName(pageName);
	   return product;
   }
   @Override
   public List<Product> getProductBySearch(String productName){
	   List<Product> product = prepo.findBySearchingName(productName);
	   return product;
   }
}
