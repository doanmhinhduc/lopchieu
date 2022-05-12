package com.example.lopchieu.model;

import com.example.lopchieu.entity.Customer;

import java.util.List;

public interface CustomerModel {
    Customer save(Customer customer);

    List<Customer> findAll();

    Customer findById(int Id);

    Customer update(int Id, Customer updateCustomer);

    boolean delete(int Id);
}
