package com.perscholas.RealEstate.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


/*
Purpose: This class is to receive the request and data from the html page and send back the requested information to the html page.
*/

@Controller
public class MainController
{
    private final Logger logger = LoggerFactory.getLogger(getClass());

   @GetMapping("/")
   public String rootHomePage()
    {
        logger.info("/////// - MAIN CONTROLLER - IN '/' - GOES TO GENERAL HOME PAGE  //////// " );
        return "html/homePageGeneral";
    }


    @GetMapping("/custButtonHandler")
    public String rootCustomerHomePage()
    {
        return "html/homePageCustomer";
    }

    @GetMapping("/adminButtonHandler")  //this is coming from 'homePageAdmin.html'
    public String rootAdminHomePage()
    {
        return "html/homePageAdmin";
    }

    @GetMapping("/contactButtonHandler")
    public String contactPage()
    {
        return "html/contactUs";
    }

    @GetMapping("/aboutButtonHandler")
    public String aboutPage()
    {
        return "html/about";
    }

    // logout
//    @RequestMapping("/")
//    public String rootHomePage(HttpServletRequest request)
//    {
////        logger.info("/////// IN REQUEST MAPPING  //////// :" );
//
//        if(request.isUserInRole("ROLE_ADMIN"))    //this is determined in the user.java class
//        {
////            logger.info("/////// IN REQUEST MAPPING - ROLE ADMIN  //////// :" );
//            return "redirect:/html/homePageAdmin/";
//        }
//
////        logger.info("/////// IN REQUEST MAPPING - ROLE customer  //////// :" );
//        return "redirect:/html/homePageCustomer/";
//    }

//    @RequestMapping("/home_general")
//    public String rootHomePage(HttpServletRequest request)
//    {
//        if(request.isUserInRole("ROLE_ADMIN"))    //this is determined in the user.java class
//        {
//            return "redirect:/html/homePageCustomer/";
//        }
//        return "redirect:/html/homePageAdmin/";
//    }



    // ----------------
//    @RequestMapping("/home")   // sang's example
//    public String defaultAfterLogin(HttpServletRequest request)
//    {
//        if(request.isUserInRole("ROLE_ADMIN")){
//            return "redirect:/admin/";
//        }
//        return "redirect:/user/";
//    }

    // ----------------


}
