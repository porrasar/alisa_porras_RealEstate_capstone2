package com.perscholas.RealEstate.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController
{
   @GetMapping("/")
   public String rootHomePage()
    {
        return "html/home_page_general";
    }

//NEED TO ADD IF STATEMENTS
    @GetMapping("/tempCustButtonHandler")
    public String rootCustomerHomePage()
    {
        return "html/home_page_customer";
    }

    @GetMapping("/tempAdminButtonHandler")
    public String rootAdminHomePage()
    {
        return "html/home_page_admin";
    }
}
