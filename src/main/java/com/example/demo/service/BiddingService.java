package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Bidding;
import com.example.demo.model.UserRegister;

public interface BiddingService {

	Bidding setBiddingDetails(int userId, Bidding bidding);

	List<Bidding> getBiddingDetails();
   
}
