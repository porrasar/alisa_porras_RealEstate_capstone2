package com.perscholas.RealEstate.repositories;

import com.perscholas.RealEstate.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
    public Customer findByUserName(String userName);   //used in customerController in "myIndividualCustomerHandler" handler

//   public List<Customer> findByFirstName(String name);

//    public List<Customer> findByUserName(String userName);
//    public Customer findByLastName(String lastName);

    public List<Customer> findByLastName(String lastName);
}
