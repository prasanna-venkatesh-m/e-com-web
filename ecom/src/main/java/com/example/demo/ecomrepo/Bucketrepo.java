package com.example.demo.ecomrepo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.users.Buckets;

public interface Bucketrepo extends CrudRepository<Buckets, Integer> {

}
