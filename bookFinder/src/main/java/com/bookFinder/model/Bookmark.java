package com.bookFinder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.netflix.ribbon.proxy.annotation.ClientProperties.Property;

@Entity
@Table(name = "bookmark")
public class Bookmark {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bookmark_id")
	private int id;	 

	@Column(name = "barcode")
	private String barcode;
	
	@Column(name = "user_id")
	private int userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Bookmark [id=" + id + ", barcode=" + barcode + ", userId=" + userId + "]";
	}
	
	
	
	
		


}
