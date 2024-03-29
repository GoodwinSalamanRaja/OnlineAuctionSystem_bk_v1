package com.example.demo.repo;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserRegister;

@Repository
public interface UserRegisterRepo extends JpaRepository<UserRegister, Integer>{
     boolean existsByUsername(String username);
     UserRegister findByUsername(String username);
     @Query(value = "SELECT * FROM REGISTERS WHERE LOWER(NAME) LIKE LOWER(:username) OR LOWER(USERNAME) LIKE LOWER(:username)",nativeQuery = true)
     List<UserRegister> findBySearchingName(String username);
     @Query(value = "SELECT * FROM REGISTERS r WHERE EXISTS (SELECT 1 FROM BIDDINGS b WHERE b.user_id = r.id)",nativeQuery = true)
     List<UserRegister> findAllWithBiddingsNotNull(PageRequest pageRequest);
     @Query(value = "SELECT * FROM REGISTERS r WHERE EXISTS (SELECT 1 FROM BIDDINGS b WHERE b.user_id = r.id AND (LOWER(r.username) LIKE LOWER(:name) OR LOWER(b.product_name) LIKE LOWER(:name)))",nativeQuery = true)
     List<UserRegister> findByBid(String name);
}
