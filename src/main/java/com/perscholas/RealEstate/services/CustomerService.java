package com.perscholas.RealEstate.services;

import com.perscholas.RealEstate.entities.Customer;

import javax.transaction.Transactional;
import java.util.List;


/*
Purpose: This class defines the business logic methods that perform CRUD and other custom operations.
 */
public interface CustomerService
{

    List<Customer> getAllCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomerById(int id);


//    Customer getCustomerByLastName(String lastName);

    void deleteCustomerById(int id);

    List<Customer> findByLastName(String lastName);
}


