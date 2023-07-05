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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

import java.util.List;

@Controller
public class CustomerController
{

    //-----------------VARIABLES ---------------------------------
    private CustomerService customerService;
    @Autowired
    private CustomerRepository repository;

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final String customersHtml = "html/customers";
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
        model.addAttribute("customers", customers);
        logger.info("/////// LIST CUSTOMERS //////// " );
//        return "html/customers";
        return customersHtml;
    }


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
        this.customerService.deleteCustomerById(id);
        return "redirect:/customersListHandler";

    }


    //---------------------UPDATE A CUSTOMER -----------
    @GetMapping("/updateCustomerPage/{id}")
    public String updateCustomerPage(@PathVariable(value = "id") int id, Model model)
    {
        // get employee from the service
        Customer customer = customerService.getCustomerById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("customer", customer);
        logger.info("/////// UPDATE CUSTOMER - @GETMAPPING  //////// :" + id );
        return updateCustomerHtml;
    }


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
        // save customer to database

        customerService.saveCustomer(customer);
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



    //------------------ACCESSING INDIVIDUAL CUSTOMER INFO WITH SECURITY---THEY ALREADY HAVE AN ACCOUNT---------------

    @GetMapping("/myIndividualCustomerHandler")      // this is coming from home_page_customer.html
    public String showIndividualCustomerInfo(Model model)
    {

        logger.info("/////// INDIVIDUAL CUSTOMER - ////////" );
        UserDetails userPrincipal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        logger.info("/////// INDIVIDUAL CUSTOMER - BEFORE USERNAME////////" );
        String username = userPrincipal.getUsername();
        logger.info("/////// INDIVIDUAL CUSTOMER - AFTER GET USERNAME////////" );
        Customer customer = repository.findByUserName(username);
        logger.info("/////// INDIVIDUAL CUSTOMER - GET CUSTOMER WITH USERNAME////////" );
        model.addAttribute("customer", customer);
        model.addAttribute("username", username);
        logger.info("/////// INDIVIDUAL CUSTOMER - GET READY TO DISPLAY INDVID. PAGE////////" );
        return "html/individualCustomerPage";
    }

}
