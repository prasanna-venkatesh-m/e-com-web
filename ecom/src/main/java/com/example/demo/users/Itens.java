package com.example.demo.users;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="items")
public class Itens {
	@Id
	private Integer itemid;
	private String itemname;
	private Integer itemprice;
	private String brand;
	private String keyword;
	public Integer getItemid() {
		return itemid;
	}
	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public Integer getItemprice() {
		return itemprice;
	}
	public void setItemprice(Integer itemprice) {
		this.itemprice = itemprice;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Itens(Integer itemid, String itemname, Integer itemprice, String brand, String keyword) {
		super();
		this.itemid = itemid;
		this.itemname = itemname;
		this.itemprice = itemprice;
		this.brand = brand;
		this.keyword = keyword;
	}
	public Itens() {
		super();
	}
	

}
