package com.perscholas.RealEstate.repositories;

import com.perscholas.RealEstate.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
    public List<Customer> findByName(String name);
}