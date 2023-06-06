package com.perscholas.alisa_porras_RealEstate_capstone2.controllers;

import com.perscholas.alisa_porras_RealEstate_capstone2.entities.Customer;
import com.perscholas.alisa_porras_RealEstate_capstone2.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController
{
    @Autowired
    private CustomerRepository repository;


    @GetMapping("/")
    public String getAllCustomers(Model model)
    {
        List<Customer> customers = repository.findAll();
        model.addAttribute("customers", customers);
        return "customers";
    }
}
