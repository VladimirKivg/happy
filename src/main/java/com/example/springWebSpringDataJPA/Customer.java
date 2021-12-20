package com.example.springWebSpringDataJPA;

import javax.persistence.*;

@Entity(name = "new_table")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String name;

  protected Customer() {
  }

  public Customer(String name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

}