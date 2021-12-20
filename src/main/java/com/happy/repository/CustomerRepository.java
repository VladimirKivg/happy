package com.happy.repository;

import java.util.List;

import com.happy.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

  List<Customer> findByName(String lastName);

  Customer findById(int id);
}