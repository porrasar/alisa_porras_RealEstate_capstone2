package com.perscholas.RealEstate.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController
{
    private final Logger logger = LoggerFactory.getLogger(getClass());

   @GetMapping("/")
   public String rootHomePage()
    {
        return "html/home_page_general";
    }

    @GetMapping("/custButtonHandler")
    public String rootCustomerHomePage()
    {
        return "html/home_page_customer";
    }

    @GetMapping("/adminButtonHandler")  //this is coming from 'home_page_admin.html'
    public String rootAdminHomePage()
    {
        return "html/home_page_admin";
    }

    @GetMapping("/contactButtonHandler")
    public String contactPage()
    {
        return "html/contact_us";
    }

    @GetMapping("/aboutButtonHandler")
    public String aboutPage()
    {
        return "html/about";
    }
}
