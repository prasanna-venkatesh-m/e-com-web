package com.example.demo.ecomrepo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.users.Itens;

public interface Itemrepo extends CrudRepository<Itens, Integer>{
	
}
