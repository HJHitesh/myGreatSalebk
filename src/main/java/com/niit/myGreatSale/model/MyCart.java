package com.niit.myGreatSale.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="MyCart")
@Component
public class MyCart implements Serializable {

	private static final long serialversionUID = 1L; /*									*/

	@Id
	private Long id;

	@Column(name = "user_id")
	private String userId;

	private int price;

	@Column(name = "product_name")
	private String name;

	@Override
	public String toString() {
		return "MyCart [id=" + id + ", userId=" + userId + ", price=" + price + ", name=" + name
				+ ", status=" + status + ", quantity=" + quantity + ", addedDate=" + addedDate + "]";
	}

	private char status;
	
	@Column(name="quantity")
	private int quantity;

	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "date_added")
	private Date addedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

}
