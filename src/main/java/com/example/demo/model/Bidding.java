package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "biddings")
public class Bidding {
   @Id
   @GeneratedValue
   private int biddingId;
   private String productName;
   private int amount;
   @ManyToOne
   @JoinColumn(name = "user_id")
   @JsonIgnore
   private UserRegister registers;
   
public UserRegister getRegisters() {
	return registers;
}
public void setRegisters(UserRegister registers) {
	this.registers = registers;
}
public int getBiddingId() {
	return biddingId;
}
public void setBiddingId(int biddingId) {
	this.biddingId = biddingId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
   
}
