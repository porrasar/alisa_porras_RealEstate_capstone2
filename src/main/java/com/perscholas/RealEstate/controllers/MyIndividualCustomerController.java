package com.perscholas.RealEstate.controllers;


import com.perscholas.RealEstate.entities.Customer;
import com.perscholas.RealEstate.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MyIndividualCustomerController
{

    //-----------------VARIABLES ---------------------------------

    @Autowired
    private CustomerRepository repository;

    private final Logger logger = LoggerFactory.getLogger(getClass());


    //-----------------METHODS ---------------------------------
    @GetMapping("/myIndividualCustomerHandler")
    public String showIndividualCustomerInfo(Model model)
    {

        logger.info("/////// MY INDV. CUSTOMER INFO - GETTING USERNAME ////////" );
        UserDetails userPrincipal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        logger.info("/////// MY INDV. CUSTOMER INFO - STORING USERNAME ////////"  );
        String username = userPrincipal.getUsername();

        logger.info("/////// MY INDV. CUSTOMER INFO - FIND BY USERNAME ////////" + username );
//        List<Customer> customerIndividualInfo = repository.findByUserName(username);
        Customer customerByUserName = repository.findByUserName(username);

        logger.info("/////// MY INDV. CUSTOMER INFO - ADDING TO MODEL ////////" + customerByUserName);
        model.addAttribute("customerByUserName", customerByUserName);
        model.addAttribute("username", username);

        logger.info("/////// MY INDV. CUSTOMER INFO - RETURNING HTML ////////" );
        return "html/addDepartmentPage";
    }
}
