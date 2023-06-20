package com.perscholas.RealEstate.controllers;


import com.perscholas.RealEstate.entities.Department;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController
{

    @GetMapping("/login")
    public String login()
    {
        return "html/login";
    }

   @GetMapping("/")
   public String rootHomePage()
    {
        return "html/home_page";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request)
    {
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/";
    }
}
