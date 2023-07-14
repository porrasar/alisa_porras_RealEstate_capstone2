package com.perscholas.RealEstate.repositories;

import com.perscholas.RealEstate.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/*
Purpose: This class is to communicate with the database in order to access and persist the data.
*/
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
    public Customer findByUserName(String userName);   //used in customerController in "myIndividualCustomerHandler" handler

    public List<Customer> findByLastName(String lastName);
    public List<Customer> findByFirstName(String firstName);
    public List<Customer> findByState(String state);
}
