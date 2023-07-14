package com.perscholas.RealEstate.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController
{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private UserService userService;

    @Autowired
    public SignupController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String showSignup(Model model)
    {
        logger.info("/////// - SIGNUP CONTROLLER - IN '/SIGNUP' - GOES TO SIGN UP PAGE  - @GETMAPPING//////// " );

        model.addAttribute("user", new User());
        logger.info("/////// - SIGNUP CONTROLLER - IN '/SIGNUP' - GOES TO SIGN UP PAGE  - @GETMAPPING//////// " + model.addAttribute("userm", new User()));
        return "html/signup";
    }

    @PostMapping("/signup")
    public String signupUser(@ModelAttribute("user") User user, Model model)
    {
        logger.info("/////// - SIGNUP CONTROLLER - IN '/SIGNUP' - GOES TO LOGIN PAGE  - @POSTMAPPING//////// " );
        User existingUser = userService.getUser(user.getUsername());
        if (existingUser != null)
        {
            logger.info("/////// - SIGNUP CONTROLLER - IN '/SIGNUP' - ERROR  - @POSTMAPPING//////// " );
            model.addAttribute(
                    "error",
                    "Username already exists. Please choose a different username.");
            return "signup";
        }

        logger.info("/////// - SIGNUP CONTROLLER - IN '/SIGNUP' - BEFORE CREATING USER  - @POSTMAPPING//////// "  + existingUser);
        userService.createUser(user);
        logger.info("/////// - SIGNUP CONTROLLER - IN '/SIGNUP' - AFTER CREATING USER  - @POSTMAPPING//////// " );
        return "redirect:/login";
    }
}
