package com.example.demo.users;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class Users {
	@Id
	private Integer id;
	private String password;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Users(Integer id, String password, String name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
	}
	public Users() {
		super();
	}
	

}
