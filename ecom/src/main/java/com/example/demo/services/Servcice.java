package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ecomrepo.Bucketrepo;
import com.example.demo.ecomrepo.Ecomuserrepo;
import com.example.demo.ecomrepo.Itemrepo;
import com.example.demo.users.Buckets;
import com.example.demo.users.Itens;
import com.example.demo.users.Search;
import com.example.demo.users.Users;

@Service
public class Servcice {
	
	static Integer orderid=1;
	
	static Integer userid;
	
	@Autowired
	public Ecomuserrepo userrepo;
	
	@Autowired
	public Itemrepo itemrepo;
	
	@Autowired
	public Bucketrepo bucketrepo;
	
	public String saveUser(Users user)
	{
		Users newuser=new Users();
		newuser.setId(user.getId());
		newuser.setPassword(user.getPassword());
		newuser.setName(user.getName());
		userrepo.save(newuser);
		return "Saved";
	}

	public String getUser(Users user) {	
		Iterable<Users> list=userrepo.findAll();
		for(Users exsist:list)
		{
			if(exsist.getId().equals(user.getId()) && exsist.getPassword().equals(user.getPassword()))
			{
				userid=user.getId();
				return "newform";
			}
		}
		return "home";
	}

	public String saveItem(Itens items) {
		if(userid==1111)
		{
		Itens newitem=new Itens();
		newitem.setItemid(items.getItemid());
		newitem.setItemname(items.getItemname());
		newitem.setItemprice(items.getItemprice());
		newitem.setBrand(items.getBrand());
		newitem.setKeyword(items.getKeyword());
		itemrepo.save(items);
		return "Item added";
		}
		else
		{
			return "User power not sufficent";
		}
	}
	
	public Iterable<Itens> getallitem() {
		Iterable<Itens> allitems=itemrepo.findAll();
		return allitems;
	}

	public Iterable<Itens> searchitem(String keyword) {
		Iterable<Itens> allitems=itemrepo.findAll();
		ArrayList<Itens> filtereditems=new ArrayList<>();
		for(Itens eachitem:allitems)
		{
			if(eachitem.getKeyword().equals(keyword))
			{
				filtereditems.add(eachitem);
			}			
		}
		Iterable<Itens> few=filtereditems;
		return few;
	}

	public String saveBucket(Integer id, Integer status) {
		Buckets newitem=new Buckets();
		java.util.Optional<Itens> existing=itemrepo.findById(id);
		Itens founded=existing.get();
		newitem.setItemid(id);
		newitem.setItemname(founded.getItemname());
		newitem.setItemprice(founded.getItemprice());
		newitem.setOrderid(orderid);
		newitem.setUserid(userid);
		newitem.setStatus(status);
		bucketrepo.save(newitem);
		orderid++;
		System.out.println(newitem.toString());
		return null;
	}
	
	public Iterable<Buckets> myitem() {
		Iterable<Buckets> allitems=bucketrepo.findAll();
		ArrayList<Buckets> filtereditems=new ArrayList<>();
		for(Buckets eachitem:allitems)
		{
			if(eachitem.getUserid().equals(userid))
			{
				filtereditems.add(eachitem);
			}			
		}
		Iterable<Buckets> fewitems=filtereditems;
		return fewitems;
	}
	
	public String logout() {
		userid=null;
		return "Logged out successfully";
	}
}
