package com.perscholas.RealEstate.controllers;

import com.perscholas.RealEstate.entities.Customer;
import com.perscholas.RealEstate.entities.Department;
import com.perscholas.RealEstate.entities.Payment;
import com.perscholas.RealEstate.entities.Payment;
import com.perscholas.RealEstate.repositories.CustomerRepository;
import com.perscholas.RealEstate.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

@Controller
public class CustomerController
{

    //-----------------VARIABLES ---------------------------------
    private CustomerService customerService;
    @Autowired
    private CustomerRepository repository;

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final String customersHtml = "html/customer_for_admin";
    private final String addCustomerHtml = "html/addCustomerPage";
    private final String updateCustomerHtml = "html/updateCustomerPage";

    private final String individualCustomerHtml = "html/individualCustomerPage";


    //-----------------CONSTRUCTOR---------------------------------
    @Autowired
    public CustomerController(CustomerService customerService)
    {
        this.customerService = customerService;
    }

    //-------------------METHODS -----------------------------------
    //---------------------LIST ALL CUSTOMERS -----------
    //display initial view/html page, list of all customers
    @GetMapping("/customersListHandler")
    public String getAllCustomers(Model model)
    {
        List<Customer> customers = repository.findAll();
        model.addAttribute("customers", customers);  // i'm passing the 'customers' object into
        logger.info("/////// LIST CUSTOMERS //////// " );
//        return "html/customers";
        return customersHtml;
    }


// ---------------------- practing


//    @GetMapping("/addNewDepartmentPage")
//    public String addNewDepartmentForm(Model model)
//    {
//        // create model attribute to bind form data
//        Department department = new Department();
//        model.addAttribute("department", department);
//        return "html/addDepartmentPage";
//    }
    @GetMapping("/customersByLastNameDisplayPageHandler")
    public String customersByLastNameDisplayPage()
    {
        logger.info("/////// IN CUSTOMER LIST BY LAST NAME DISPLAY //////// " );
        return "html/customersByLastNameDisplayPage";

    }

    @GetMapping("/searchCustomersByLastNameDisplayPageHandler/{lastNameId}")
    public String getAllCustomersByLastName(@PathVariable String lastNameId, Model model)
    {
        logger.info("/////// IN GET ALL LAST NAMES BEFORE READING DB //////// " );
        List<Customer> customersLastName = repository.findByLastName(lastNameId);

        logger.info("/////// IN GET ALL LAST -  AFTER READING DB //////// " );
        model.addAttribute("customers", customersLastName);

        logger.info("/////// IN GET ALL LAST -  AFTER ADDING TO MDL//////// " );

        return "html/customersByLastName";
    }

// ---------------------- practing

    //---------------------ADD NEW CUSTOMER -----------
    @GetMapping("/addNewCustomerForm")
    public String addNewCustomerForm(Model model)
    {
        // create model attribute to bind form data
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return addCustomerHtml;
    }

    //---------------------DELETE A CUSTOMER -----------
    @GetMapping("/deleteCustomerPage/{id}")
    public String deleteCustomerPage(@PathVariable(value = "id") int id)
    {
        // call delete customer method
//        this.customerService.deleteCustomerById(id);
//        return "redirect:/customersListHandler";


        try
        {
            this.customerService.deleteCustomerById(id);
        }
        catch(Exception e)
        {
            logger.info("/////// Customer not found  //////// ");
        }

        return "redirect:/customersListHandler";
    }


    //---------------------UPDATE A CUSTOMER -----------
    @GetMapping("/updateCustomerPage/{id}")
    public String updateCustomerPage(@PathVariable(value = "id") int id, Model model)
    {//beginning
        // get employee from the service
        Customer customer = customerService.getCustomerById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("customer", customer);
        logger.info("/////// UPDATE CUSTOMER - @GETMAPPING  //////// :" + id);

        return updateCustomerHtml;

    }//ending

    //---------------------SAVE DATA TO DATABASE -----------
    //Save user data to database
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") @Valid Customer customer,
                               BindingResult bindingResult)
    {//beginning
        if (bindingResult.hasErrors())
        {
            return addCustomerHtml;
        }
        // save customer to database

//        customerService.saveCustomer(customer);
//        return "redirect:/customersListHandler";

        try
        {
          customerService.saveCustomer(customer);
        }
        catch(Exception e)
        {
            logger.info("/////// Failed to save request //////// ");
        }

        return "redirect:/customersListHandler";

    }//ending





    //-----------------ADD A PAYMENT TO A CUSTOMER PROCESS------------------
    @GetMapping("/addPaymentToCustomerPageHandler/{cId}")
    public String addPaymentToCustomer(@PathVariable int cId, Model model)
    {
        // create model attribute to bind form data
        Payment payment = new Payment();
        model.addAttribute("payment", payment);
        model.addAttribute("cId", cId);
        logger.info("/////// ADD PAYMENT TO CUSTOMER - @GETMAPPING  //////// :" + cId );
        return "html/payment/addPaymentToCustomerPage";
    }


    @PostMapping("/customerPageHandler/{cId}/paymentPageHandler")
    public String savePaymentToCustomer(@PathVariable int cId,
                                        Model model,
                                        @ModelAttribute ("payment")
                                        @Valid Payment payment,
                                        BindingResult bindingResult)
    {


        //go get customer with the customerId that was passed in addPaymentToCustomer()
        Customer customer = customerService.getCustomerById(cId);

        if (bindingResult.hasErrors())
        {
            return updateCustomerHtml;
        }

        List<Payment> paymentList = customer.getPaymentList();
        paymentList.add(payment);

        customerService.saveCustomer(customer);

        return "redirect:/customersListHandler";

    }

    //---------ACCESSING INDIVIDUAL CUSTOMER INFO WITH SECURITY BY USERNAME ---THEY ALREADY HAVE AN ACCOUNT---------------

    @GetMapping("/myIndividualCustomerHandler")      // this is coming from home_page_customer.html
    public String showIndividualCustomerInfo(Model model)
    {
        UserDetails userPrincipal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username = userPrincipal.getUsername();

        Customer customer = repository.findByUserName(username);

        model.addAttribute("customer", customer);

        return individualCustomerHtml;
    }



    }
