package com.perscholas.RealEstate.controllers;


import com.perscholas.RealEstate.entities.Customer;
import com.perscholas.RealEstate.entities.Department;
import com.perscholas.RealEstate.entities.Payment;
import com.perscholas.RealEstate.repositories.DepartmentRepository;
import com.perscholas.RealEstate.repositories.PaymentRepository;
import com.perscholas.RealEstate.services.DepartmentService;
import com.perscholas.RealEstate.services.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

/*
Purpose: This class is to receive the request and data from the html page and send back the requested information to the html page.
         It performs the CRUD (Create, Read, Update, and Delete) functions for the Customer table.
         It has a 1:m (customer:payments) relationship, defined in Customer.java
*/
@Controller
public class PaymentController
{
    //-----------------VARIABLES ----------------------------------------------------------
    private PaymentService paymentService;

    @Autowired
    private PaymentRepository repository;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    //-----------------CONSTRUCTOR----------------------------------------------------------
    @Autowired
    public PaymentController(PaymentService paymentService)
    {
        this.paymentService = paymentService;
    }



    //-------------------METHODS -----------------------------------------------------------


    //---------------------LIST ALL PAYMENTS -----------
    //display initial view/html page, list of all payments
    @GetMapping("/paymentsListHandler")
    public String getAllPayments(Model model)
    {
        List<Payment> payments = repository.findAll();
        // the 1st 'departments' is a made up name, for the key, of the key, valued pair of the Model class
        // the 2nd 'departments' is the object variable for the list type
        logger.info("/////// LIST OF DEPARTMENTS ////////" + repository.findAll());
        model.addAttribute("payments", payments);
        return "html/Payment/PaymentPage";

    }

    //---------------------ADD NEW PAYMENT -----------
    //Add a new payment
    @GetMapping("/addNewPaymentPage")
    public String addNewPaymentForm(Model model)
    {
        // create model attribute to bind form data
        Payment payment = new Payment();
        model.addAttribute("payment", payment);
        return "html/Payment/addPaymentPage";
    }

    //---------------------DELETE A PAYMENT -----------
    @GetMapping("/deletePaymentPageHandler/{id}")
    public String deletePaymentPage(@PathVariable(value = "id") int id)
    {

        // call delete department method
        this.paymentService.deletePaymentById(id);
        logger.info("/////// DELETE PAYMENT //////// :" + id + " HAS BEEN DELETED");
        return "redirect:/paymentsListHandler";
    }

    //---------------------UPDATE A PAYMENT -----------
    @GetMapping("/updatePaymentPageHandler/{id}")
    public String updatePaymentPage(@PathVariable(value = "id") int id, Model model)
    {
        // get department from the service
        Payment payment = paymentService.getPaymentById(id);

        // set payment as a model attribute to pre-populate the form
        model.addAttribute("payment", payment);
        return "html/Payment/updatePaymentPage";
    }

    //---------------------SAVE DATA TO DATABASE -----------

    //    <!-- Add hidden form field to handle update -- >

    //Save user data to database
    @PostMapping("/savePayment")
    public String saveDepartment(@ModelAttribute("payment")
                                 @Valid Payment payment,
                                 BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return "html/addPaymentPage";
        }
        // save customer to database
//        paymentService.savePayment(payment);
//        return "redirect:/paymentsListHandler";

        try
        {
            paymentService.savePayment(payment);
        }
        catch(Exception e)
        {
            logger.info("/////// Failed to save request //////// ");
        }
        return "redirect:/paymentsListHandler";

    }



}
