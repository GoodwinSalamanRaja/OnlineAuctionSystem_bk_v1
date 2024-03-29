package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Bidding;
import com.example.demo.model.UserRegister;
import com.example.demo.repo.BiddingRepo;
import com.example.demo.repo.UserRegisterRepo;
import com.example.demo.service.BiddingService;

@Service
public class BiddingServiceImpl implements BiddingService{
   @Autowired
   private BiddingRepo brepo;
   @Autowired
   private UserRegisterRepo urepo;
   public Bidding setBiddingDetails(int userId,Bidding bidding) {
	   UserRegister user = urepo.findById(userId).get();
	   bidding.setRegisters(user);
	   Bidding savedDetails = brepo.saveAndFlush(bidding);
	   return savedDetails;
   }
   @Override
   public List<Bidding> getBiddingDetails(){
	   List<Bidding> bids = brepo.findAll();
	   return bids;
   }
}
