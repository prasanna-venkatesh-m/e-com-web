package com.example.demo.ecomrepo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.users.Users;

public interface Ecomuserrepo extends CrudRepository<Users, Integer>{

}
