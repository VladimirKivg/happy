package com.example.springWebSpringDataJPA;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

  List<Customer> findByName(String lastName);

  Customer findById(int id);
}