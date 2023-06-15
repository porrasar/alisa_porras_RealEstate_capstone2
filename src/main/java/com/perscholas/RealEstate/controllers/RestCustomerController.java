package com.perscholas.RealEstate.controllers;

import com.perscholas.RealEstate.entities.Customer;
import com.perscholas.RealEstate.repositories.CustomerRepository;
import com.perscholas.RealEstate.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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

    //display initial view/html page, list of all customers
    @GetMapping("/customersList")
    //http://localhost:8081/rest/customersList
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

    @GetMapping("/deleteCustomerPage/{id}")
    public String deleteCustomerPage(@PathVariable(value = "id") int id)
    {
        // call delete customer method
        this.customerService.deleteCustomerById(id);
        return "redirect:/customersList";

    }


    @GetMapping("/updateCustomerPage/{id}")
    public String updateCustomerPage(@PathVariable(value = "id") int id, Model model)
    {
        // get employee from the service
        Customer customer = customerService.getCustomerById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("customer", customer);
        return "html/updateCustomerPage";
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
        return "redirect:/customersList";
    }
}
