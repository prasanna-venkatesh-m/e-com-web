package com.example.demo.users;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="myitems")
public class Buckets {
	@Id
	private Integer orderid;
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	private Integer userid;
	private Integer itemid;
	private String itemname;
	private Integer itemprice;
	private Integer status;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Buckets(Integer userid, Integer itemid, String itemname, Integer itemprice, Integer status) {
		super();
		this.userid = userid;
		this.itemid = itemid;
		this.itemname = itemname;
		this.itemprice = itemprice;
		this.status = status;
	}
	public Buckets() {
		super();
	}
	

}
