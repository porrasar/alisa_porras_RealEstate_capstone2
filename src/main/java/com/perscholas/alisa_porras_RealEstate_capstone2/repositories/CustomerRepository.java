package com.perscholas.alisa_porras_RealEstate_capstone2.repositories;

import com.perscholas.alisa_porras_RealEstate_capstone2.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
    public Customer findFirstByName(String name);

    public List<Customer> findByName(String name);
//    public List<Customer> findByNameAndAge(String name, int age);

    public List<Customer> findByNameAndZip(String name, int zip);

}
