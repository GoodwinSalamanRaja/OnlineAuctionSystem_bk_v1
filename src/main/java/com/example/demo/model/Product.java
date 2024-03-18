package com.example.demo.model;

import java.io.File;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
   @Id
   @GeneratedValue
   private int id;
   private String name;
   private String category;
   private String description;
   private String regprice;
   private String bidprice;
   private String biddate;
   private String image;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getRegprice() {
	return regprice;
}
public void setRegprice(String regprice) {
	this.regprice = regprice;
}
public String getBidprice() {
	return bidprice;
}
public void setBidprice(String bidprice) {
	this.bidprice = bidprice;
}
public String getBiddate() {
	return biddate;
}
public void setBiddate(String biddate) {
	this.biddate = biddate;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
   
}