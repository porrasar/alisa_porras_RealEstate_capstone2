package com.perscholas.RealEstate.controllers;

import com.perscholas.RealEstate.entities.Customer;
import com.perscholas.RealEstate.entities.Payment;
import com.perscholas.RealEstate.repositories.CustomerRepository;
import com.perscholas.RealEstate.services.CustomerService;
import com.perscholas.RealEstate.user.User;
import com.perscholas.RealEstate.user.UserRepository;
import com.perscholas.RealEstate.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.security.Principal;
import java.util.List;

/*
Purpose: This class is to receive the request and data from the html page and send back the requested information to the html page.
         It performs the CRUD (Create, Read, Update, and Delete) functions for the Customer table.
         It also performs adding a payment to a customer, which has a 1:m (customer:payments) relationship
*/

@Controller
public class CustomerController
{

    //-----------------VARIABLES ---------------------------------
    private CustomerService customerService;
    private String holdUserName;
    @Autowired
    private CustomerRepository repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final String customersHtml = "html/customerForAdmin";
    private final String addCustomerHtml = "html/addCustomerPage";
    private final String updateCustomerHtml = "html/updateCustomerPage";
    private final String updateCustomerByCustomerHtml = "html/updateCustomerPageByTheCustomer";

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
        return customersHtml;

    }

// ---------------------- practing lastname access

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

// ---------------------- practing  -------------------------

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

        this.customerService.deleteCustomerById(id);
        logger.info("/////// Customer not found  //////// ");

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
        logger.info("/////// UPDATE CUSTOMER - @GETMAPPING   - DID I COME THROUHGH HERE//////// :" + customer);

        return updateCustomerHtml;

    }//ending



    //---------------------SAVE DATA TO DATABASE -----------
    //Save user data to database
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") @Valid Customer customer,
                               BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return addCustomerHtml;
        }

        // save customer to database.

        customerService.saveCustomer(customer);

        return "redirect:/customersListHandler";

    }

    //---------------------SAVE UPDATED CUSTOMER DATA TO DATABASE -----------
    //Save user data to database
    @PostMapping("/saveUpdatedCustomer")
    public String saveCustomerUpdated(@ModelAttribute("customer") @Valid Customer customer,
                               BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return addCustomerHtml;
        }

        // save customer to database. Had to pull the customer record from the repository, in order to keep the
        // payment information on my html page. Then updating the customer record from the repository, with
        // the changes from the model customer record

        Customer customerById =  repository.getById(customer.getcId());

        customerById.setFirstName(customer.getFirstName());
        customerById.setLastName(customer.getLastName());
        customerById.setAddress(customer.getAddress());
        customerById.setCity(customer.getCity());
        customerById.setState(customer.getState());
        customerById.setZip(customer.getZip());
        customerById.setSecurityName(customer.getSecurityName());
        customerById.setUserName(customer.getUserName());

        customerService.saveCustomer(customerById);

        return "redirect:/customersListHandler";

    }

    //-----------------ADD A PAYMENT TO A CUSTOMER PROCESS------------------
    @GetMapping("/addPaymentToCustomerPageHandler/{cId}")
    public String addPaymentToCustomer(@PathVariable int cId, Model model)
    {
        // create model attribute to bind form data
        Payment payment = new Payment();
        model.addAttribute("payment", payment);
        model.addAttribute("cId", cId);

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

    @GetMapping("/myIndividualCustomerHandler")      // this is coming from homePageCustomer.html
    public String showIndividualCustomerInfo(Model model)
    {
        UserDetails userPrincipal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username = userPrincipal.getUsername();

        Customer customer = repository.findByUserName(username);

        model.addAttribute("customer", customer);

        return individualCustomerHtml;
    }

    //---------------------------------------------------------------------
    //---------------------UPDATE  PROCESS FOR USERNAME BY THE CUSTOMER -----------
    @GetMapping("/updateCustomerPageByTheCustomer/{id}")
    public String updateCustomerPageByTheCustomer(@PathVariable(value = "id") int id, Model model)
    {//beginning
        // get customer from the service
        Customer customer = customerService.getCustomerById(id);

        // set customer as a model attribute to pre-populate the form
        model.addAttribute("customer", customer);
        logger.info("/////// UPDATE - UPDATE CUSTOMER - @GETMAPPING  //////// :" + id);

        return updateCustomerByCustomerHtml;

    }//ending

    //---------------------SAVE DATA TO DATABASE -----------
    //Save user data to database
    @PostMapping("/saveCustomerByCustomer")
    public String saveCustomerByCustomer(@ModelAttribute("customer") @Valid Customer customer,
                                         BindingResult bindingResult, Principal principal)
    {//beginning

        logger.info("/////// SAVE - WHICH CUSTOMER - before save: //////// " + customer);

        if (bindingResult.hasErrors())
        {
            return updateCustomerByCustomerHtml;
        }

        // save customer to database
        customerService.saveCustomer(customer);
        logger.info("/////// SAVE - WHICH CUSTOMER: //////// " + customer);


              //getting user record and updating the username
        String oldUserName = principal.getName();
        String newUserName = customer.getUserName();
        logger.info("/////// SAVE -  SECURITY NAME - old user name from user record: //////// " + oldUserName);
        logger.info("/////// SAVE -  SECURITY NAME - new user name from saved customer record: //////// " + newUserName);

        User user = userRepository.findByUsername(oldUserName);
        logger.info("/////// SAVE - USER RECORD - GET USER RECORD with old username  //////// :" + oldUserName + " " + user);

        user.setUsername(newUserName);
        logger.info("/////// SAVE - USER RECORD - get USER name,should be new name   //////// :" + user.getUsername());

       userRepository.save(user);
        logger.info("/////// SAVE - USER RECORD - after update  //////// :" + user);


        return "redirect:/customersListHandler";
//
    }//ending

//---------------------------------------------------------------------



}
