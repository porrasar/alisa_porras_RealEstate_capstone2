package com.perscholas.alisa_porras_RealEstate_capstone2.controllers;

import com.perscholas.alisa_porras_RealEstate_capstone2.entities.Customer;
import com.perscholas.alisa_porras_RealEstate_capstone2.repositories.CustomerRepository;
import com.perscholas.alisa_porras_RealEstate_capstone2.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

import java.util.List;

@Controller
public class CustomerController
{

    private CustomerService customerService;
    @Autowired
    private CustomerRepository repository;


    //display initial view/html page, list of all customers
    @GetMapping("/")
    public String getAllCustomers(Model model)
    {
        List<Customer> customers = repository.findAll();
        model.addAttribute("customers", customers);
        return "html/customers";
    }


    //Add a new customer
    @GetMapping("/addNewCustomerForm")
    public String addNewCustomerForm(Model model)
    {
        // create model attribute to bind form data
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "html/addCustomerPage";
    }


    @GetMapping("/updateCustomerForm")
    public String updateCustomerForm(Model model)
    {
        // create model attribute to bind form data
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "html/updateCustomerPage";
    }

    @GetMapping("/confirmDeletePage")
    public String confirmDeletePage(Model model)
    {
        // create model attribute to bind form data
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "html/confirmDeletePage";
    }

    @GetMapping("/deleteCustomerForm")
    public String deleteCustomerForm(Model model)
    {
        // create model attribute to bind form data
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "html/confirmDeleteCustomerPage";
    }


    //Save user data to database
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") @Valid Customer customer,
                               BindingResult bindingResult)
    {

        if (bindingResult.hasErrors())
        {
            return "html/addCustomerPage";
        }

        // save customer to database
        customerService.saveCustomer(customer);
        return "redirect:/";
    }

}
