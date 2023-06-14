package com.perscholas.RealEstate.controllers;


import com.perscholas.RealEstate.entities.Department;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController
{
    @GetMapping("/")
    public String login()
    {
        return "html/home_page";
    }
}
