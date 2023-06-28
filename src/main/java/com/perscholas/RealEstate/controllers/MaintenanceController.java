package com.perscholas.RealEstate.controllers;


import com.perscholas.RealEstate.entities.House;
import com.perscholas.RealEstate.entities.Maintenance;
import com.perscholas.RealEstate.repositories.HouseRepository;
import com.perscholas.RealEstate.repositories.MaintenanceRepository;
import com.perscholas.RealEstate.services.MaintenanceService;
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
public class MaintenanceController
{

    //-----------------VARIABLES ---------------------------------
    private MaintenanceService maintenanceService;
    @Autowired
    private MaintenanceRepository repository;

    //-----------------CONSTRUCTOR---------------------------------
    @Autowired
    public MaintenanceController(MaintenanceService maintenanceService)
    {
        this.maintenanceService = maintenanceService;
    }

    //-------------------METHODS -----------------------------------

    //display initial view/html page, list of all maintenances
    @GetMapping("/MaintenanceListHandlerAdmin")
    public String getAllMaintenanceAdmin(Model model)
    {
        List<Maintenance> maintenances = repository.findAll();
        model.addAttribute("maintenances", maintenances);
        return "html/Maintenance_for_Admin";
    }

    @GetMapping("/MaintenanceListHandlerCustomer")
    public String getAllMaintenanceCustomer(Model model)
    {
        List<Maintenance> maintenances = repository.findAll();
        model.addAttribute("maintenances", maintenances);
        return "html/Maintenance_for_Customer";
    }



    //Add a new customer
    @GetMapping("/addNewMaintenanceForm")
    public String addNewMaintenanceForm(Model model)
    {
        // create model attribute to bind form data
        Maintenance maintenance = new Maintenance();
        model.addAttribute("maintenance", maintenance);
        return "html/addMaintenancePage";
    }

    @GetMapping("/deleteMaintenancePage/{id}")
    public String deleteMaintenancePage(@PathVariable(value = "id") int id)
    {
        // call delete Maintenance method
        this.maintenanceService.deleteMaintenanceById(id);
        return "redirect:/MaintenanceListHandler";

    }


    @GetMapping("/updateMaintenancePage/{id}")
    public String updateMaintenancePage(@PathVariable(value = "id") int id, Model model)
    {
        // get Maintenance from the service
        Maintenance maintenance = maintenanceService.getMaintenanceById(id);

        // set Maintenance as a model attribute to pre-populate the form
        model.addAttribute("maintenance", maintenance);
        return "html/updateMaintenancePage";
    }

    //Save user data to database
    @PostMapping("/saveMaintenance")
    public String saveMaintenance(@ModelAttribute("maintenance") @Valid Maintenance maintenance,
                               BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return "html/addMaintenancePage";
        }
        // save Maintenance to database
        maintenanceService.saveMaintenance(maintenance);
        return "redirect:/MaintenanceListHandlerAdmin";
    }

}



