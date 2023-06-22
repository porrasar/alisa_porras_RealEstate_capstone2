package com.perscholas.RealEstate.services;


import com.perscholas.RealEstate.entities.Customer;
import com.perscholas.RealEstate.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Primary
public class CustomerServiceImpl implements CustomerService
{
    //-----------------------------VARIABLES-------------------------------------
    private CustomerRepository customerRepository;
    private Customer customer;

    //-----------------------------CONSTRUCTOR-------------------------------------
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }


    //-----------------------------METHODS------------------------------------
    @Override
    public List<Customer> getAllCustomers()
    {
        return customerRepository.findAll();
    }


    @Override
    public void saveCustomer(Customer customer)
    {
        customerRepository.save(customer);
    }


    /**
     * Returns an Employee object based on id argument.
     * <p>
     * Some more description of the method.
     *
     * @param  id  id of an employee
     * @return      Employee object
     */
    @Override
    public Customer getCustomerById(int id)
    {

        Optional<Customer> optionalEmployee = customerRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Customer employee = optionalEmployee.get();
            return employee;
        }
        throw new CustomerNotFoundException();
    }

//    @Override
//    public Customer getCustomerByName(String name)
//    {
//        Customer employee = customerRepository.findFirstByName(name);
//        if (employee == null) {
//            throw new CustomerNotFoundException();
//        }
//        return employee;
//    }
//
    @Override
    public void deleteCustomerById(int id)
    {
        customerRepository.deleteById(id);
    }
}