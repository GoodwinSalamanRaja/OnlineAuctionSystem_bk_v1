package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Bidding;
import com.example.demo.model.UserRegister;
import com.example.demo.service.BiddingService;

@RestController
@RequestMapping("/bidding")
public class BiddingController {
    @Autowired
    private BiddingService bservice;
    @PostMapping("/set/{userId}")
    public ResponseEntity<?> setBiddingDetails(@PathVariable int userId,@RequestBody Bidding bidding){
    	Bidding user = bservice.setBiddingDetails(userId, bidding);
    	return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    @GetMapping("getAll")
    public ResponseEntity<?> getBiddingDetails(){
    	List<Bidding> bids = bservice.getBiddingDetails();
    	return ResponseEntity.status(HttpStatus.OK).body(bids);
    }
}
