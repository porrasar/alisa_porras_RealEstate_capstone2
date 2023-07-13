package com.perscholas.RealEstate.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController
{


//    @GetMapping("/loginHomePageGeneralHandler")
//    public String loginHomeGeneral()
//    {
//        return "html/home_page_general";
//    }

//    @GetMapping("/login")
//    public String login() {
////        return "html/login";
//        return "html/home_page_customer";
//    }


    @GetMapping("/login")
    public String loginPage()
    {
        return "html/login";
    }

// --------------------

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/";
    }






}

