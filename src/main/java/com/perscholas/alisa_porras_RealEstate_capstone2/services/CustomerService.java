package com.perscholas.alisa_porras_RealEstate_capstone2.services;

import com.perscholas.alisa_porras_RealEstate_capstone2.entities.Customer;

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


