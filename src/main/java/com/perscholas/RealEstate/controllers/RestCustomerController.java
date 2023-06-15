package com.perscholas.RealEstate.controllers;

import com.perscholas.RealEstate.entities.Customer;
import com.perscholas.RealEstate.repositories.CustomerRepository;
import com.perscholas.RealEstate.services.CustomerNotFoundException;
import com.perscholas.RealEstate.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestCustomerController
{
    //-----------------VARIABLES ---------------------------------
    private CustomerService customerService;
    @Autowired
    private CustomerRepository repository;

    //-----------------CONSTRUCTOR---------------------------------
    @Autowired
    public RestCustomerController(CustomerService customerService)
    {
        this.customerService = customerService;
    }

    //-------------------METHODS -----------------------------------

    //---------------------LIST ALL CUSTOMERS -----------
    //display initial view/html page, list of all customers
    @GetMapping("/customersList")
    //http://localhost:8081/rest/customersList
    public List<Customer> getAllCustomers()
    {
        List<Customer> customers = repository.findAll();
         return customers;
    }

    //---------------------ADD NEW CUSTOMER -----------

    //Add a new customer
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    //http://localhost:8081/rest/addNewCustomerForm
    public void addNewCustomer(@RequestBody Customer customer)
    {
        customerService.saveCustomer(customer);
    }

    //---------------------DELETE A CUSTOMER -----------

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable(value = "id") int id)
    {
          customerService.deleteCustomerById(id);
    }

    //---------------------UPDATE A CUSTOMER -----------
    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable(value = "id") int id, @RequestBody Customer customer)
    {
        Customer existingCustomer = customerService.getCustomerById(id);

        if (existingCustomer == null)
        {
            throw new CustomerNotFoundException();
        }
        customerService.saveCustomer(customer);
        return customerService.getCustomerById(id);
    }

}
