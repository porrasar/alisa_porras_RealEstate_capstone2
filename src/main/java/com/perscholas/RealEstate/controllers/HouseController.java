package com.perscholas.RealEstate.controllers;


import com.perscholas.RealEstate.entities.Customer;
import com.perscholas.RealEstate.entities.House;
import com.perscholas.RealEstate.repositories.CustomerRepository;
import com.perscholas.RealEstate.repositories.HouseRepository;
import com.perscholas.RealEstate.services.CustomerService;
import com.perscholas.RealEstate.services.HouseService;
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

@Controller
public class HouseController
{

    //-----------------VARIABLES ---------------------------------
    private HouseService houseService;
    @Autowired
    private HouseRepository repository;

    //-----------------CONSTRUCTOR---------------------------------
    @Autowired
    public HouseController(HouseService houseService)
    {
        this.houseService = houseService;
    }

    //-------------------METHODS -----------------------------------

    //display initial view/html page, list of all customers
    @GetMapping("/housesListHandler")
    public String getAllHouses(Model model)
    {
        List<House> houses = repository.findAll();
        model.addAttribute("houses", houses);
        return "html/houses";
    }


    //Add a new customer
    @GetMapping("/addNewHouseForm")
    public String addNewHouseForm(Model model)
    {
        // create model attribute to bind form data
        House house = new House();
        model.addAttribute("house", house);
        return "html/addHousePage";
    }

    @GetMapping("/deleteHousePage/{id}")
    public String deleteHousePage(@PathVariable(value = "id") int id)
    {
        // call delete house method
        this.houseService.deleteHouseById(id);
        return "redirect:/housesListHandler";

    }


    @GetMapping("/updateHousePage/{id}")
    public String updateHousePage(@PathVariable(value = "id") int id, Model model)
    {
        // get house from the service
        House house = houseService.getHouseById(id);

        // set house as a model attribute to pre-populate the form
        model.addAttribute("house", house);
        return "html/updateHousePage";
    }

    //Save user data to database
    @PostMapping("/saveHouse")
    public String saveHouse(@ModelAttribute("house") @Valid House house,
                               BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return "html/addHousePage";
        }
        // save house to database
        houseService.saveHouse(house);
        return "redirect:/housesListHandler";
    }

}



