package com.perscholas.RealEstate.controllers;


import com.perscholas.RealEstate.entities.House;
import com.perscholas.RealEstate.entities.Maintenance;
import com.perscholas.RealEstate.repositories.HouseRepository;
import com.perscholas.RealEstate.repositories.MaintenanceRepository;
import com.perscholas.RealEstate.services.MaintenanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(getClass());
    //-----------------CONSTRUCTOR---------------------------------
    @Autowired
    public MaintenanceController(MaintenanceService maintenanceService)
    {
        this.maintenanceService = maintenanceService;
    }

    //------------------- METHODS -----------------------------------
    //---------------------LIST ALL MAINTENANCE COMPANIES ------------------------
    // ------------Page for list of maintenance companies for administration ------
    @GetMapping("/maintenanceListHandlerAdmin")
    public String getAllMaintenanceAdmin(Model model)
    {
        List<Maintenance> maintenances = repository.findAll();
        model.addAttribute("maintenances", maintenances);
        return "html/maintenance_for_admin";
    }

    // ------------Page for list of maintenance companies for customer -----------
    @GetMapping("/maintenanceListHandlerCustomer")
    public String getAllMaintenanceCust(Model model)
    {
        List<Maintenance> maintenances = repository.findAll();
        model.addAttribute("maintenances", maintenances);
        return "html/maintenance_for_cust";
    }

//---------------------ADD NEW MAINTENANCE COMPANY -----------------------------

    //Add a new customer
    @GetMapping("/addNewMaintenanceForm")
    public String addNewMaintenanceForm(Model model)
    {
        // create model attribute to bind form data
        logger.info("///////ADD MAINTENANCE COMPANY //////// " );
        Maintenance maintenance = new Maintenance();
        model.addAttribute("maintenance", maintenance);
        logger.info("///////ADD MAINTENANCE COMPANY - before html  /////// " );
        return "html/addMaintenancePage";
    }
    //---------------------DELETE A MAINTENANCE COMPANY -----------------------
    @GetMapping("/deleteMaintenancePage/{id}")
    public String deleteMaintenancePage(@PathVariable(value = "id") int id)
    {
        // call delete Maintenance method
        this.maintenanceService.deleteMaintenanceById(id);
        return "redirect:/maintenanceListHandler";

    }


    //---------------------UPDATE A MAINTENANCE COMPANY -----------------------
    @GetMapping("/updateMaintenancePage/{id}")
    public String updateMaintenancePage(@PathVariable(value = "id") int id, Model model)
    {
        // get Maintenance from the service
        Maintenance maintenance = maintenanceService.getMaintenanceById(id);

        // set Maintenance as a model attribute to pre-populate the form
        model.addAttribute("maintenance", maintenance);
        return "html/updateMaintenancePage";
    }

    //---------------------SAVE DATA TO DATABASE ------------------------------
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
//        maintenanceService.saveMaintenance(maintenance);
//        return "redirect:/MaintenanceListHandler";


        try
        {
            maintenanceService.saveMaintenance(maintenance);
        }
        catch(Exception e)
        {
            logger.info("/////// Failed to save request //////// ");
        }

        return "redirect:/MaintenanceListHandler";

    }

}



