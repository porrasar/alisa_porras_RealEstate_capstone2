package com.perscholas.RealEstate.services;

import com.perscholas.RealEstate.entities.Customer;

import java.util.List;

public interface CustomerService
{

    List<Customer> getAllCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomerById(int id);

//
//    Customer getCustomerByName(String name);

    void deleteCustomerById(int id);
}


