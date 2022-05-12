package com.example.lopchieu.model;

import com.example.lopchieu.entity.Customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InMenoryCustomer implements CustomerModel {

    private static List<Customer> customers;

    public InMenoryCustomer(){
        customers = new ArrayList<>();
        customers.add(
                new Customer(
                        1,
                        "minhduc",
                        "0348348384",
                        "sadas",
                        LocalDateTime.of(2005,10,10,0,0),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
    }


    @Override
    public Customer save(Customer customer) {
       customers.add(customer);
       return customer;
    }

    @Override
    public List<Customer> findAll() {
       return customers;
    }

    @Override
    public Customer findById(int Id) {
        Customer found = null;
        for (Customer customer :
                customers) {
            if (customer.getId() == (Id)) {
                found = customer;
                break;
            }
        }
        return found;
    }

    @Override
    public Customer update(int Id, Customer updateCustomer) {
        Customer existingCustomer = findById(Id);
        if(existingCustomer == null){
            return null;
        }
        existingCustomer.setName(updateCustomer.getName());
        existingCustomer.setPhone(updateCustomer.getPhone());
        existingCustomer.setImage(updateCustomer.getImage());
        existingCustomer.setDob(updateCustomer.getDob());
        existingCustomer.setUpdateAt(LocalDateTime.now());
        existingCustomer.setStatus(updateCustomer.getStatus());
        return existingCustomer;
    }

    @Override
    public boolean delete(int Id) {
        int foundIndex = -1;
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getId() == (Id)){
                foundIndex = i;
            }
        }
        if(foundIndex != -1){
            customers.remove(foundIndex);
            return true;
        }
        return false;
    }
}

