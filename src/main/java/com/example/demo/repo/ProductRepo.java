package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
   @Query(value = "SELECT * FROM PRODUCTS WHERE CATEGORY = :pageName",nativeQuery = true)
   List<Product> findByName(String pageName);
   @Query(value = "SELECT * FROM PRODUCTS WHERE LOWER(NAME) LIKE LOWER(:productName) OR LOWER(CATEGORY) LIKE LOWER(:productName)",nativeQuery = true)
   List<Product> findBySearchingName(String productName);
}
