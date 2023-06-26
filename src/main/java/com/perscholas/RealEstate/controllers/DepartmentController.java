package com.perscholas.RealEstate.controllers;


import com.perscholas.RealEstate.entities.Customer;
import com.perscholas.RealEstate.entities.Department;
import com.perscholas.RealEstate.repositories.DepartmentRepository;

import com.perscholas.RealEstate.services.CustomerService;
import com.perscholas.RealEstate.services.DepartmentService;
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
public class DepartmentController
{



    //-----------------VARIABLES ----------------------------------------------------------
    private DepartmentService departmentService;

    @Autowired
    private DepartmentRepository repository;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    //-----------------CONSTRUCTOR----------------------------------------------------------
    @Autowired
    public DepartmentController(DepartmentService departmentService)
    {
        this.departmentService = departmentService;
    }



    //-------------------METHODS -----------------------------------------------------------


    //---------------------LIST ALL DEPARTMENTS -----------
    //display initial view/html page, list of all departments
    @GetMapping("/departmentsListHandler")
    public String getAllDepartment(Model model)
    {
        List<Department> departments = repository.findAll();
        // the 1st 'departments' is a made up name, for the key, of the key, valued pair of the Model class
        // the 2nd 'departments' is the object variable for the list type
        logger.info("/////// LIST OF DEPARTMENTS ////////" + repository.findAll());
        model.addAttribute("departments", departments);
        return "html/departmentPage";

    }

    //---------------------ADD NEW DEPARTMENT -----------
    //Add a new department
    @GetMapping("/addNewDepartmentPage")
    public String addNewDepartmentForm(Model model)
    {
        // create model attribute to bind form data
        Department department = new Department();
        model.addAttribute("department", department);
        return "html/addDepartmentPage";
    }

    //---------------------DELETE A DEPARTMENT -----------
    @GetMapping("/deleteDepartmentPageHandler/{id}")
    public String deleteDepartmentPage(@PathVariable(value = "id") int id)
    {

        // call delete department method
        this.departmentService.deleteDepartmentById(id);
        logger.info("/////// DELETE DEPARTMENT //////// :" + id + " HAS BEEN DELETED");
        return "redirect:/departmentsListHandler";
    }

    //---------------------UPDATE A DEPARTMENT -----------
    @GetMapping("/updateDepartmentPageHandler/{id}")
    public String updateDepartmentPage(@PathVariable(value = "id") int id, Model model)
    {
        // get department from the service
        Department department = departmentService.getDepartmentById(id);

        // set department as a model attribute to pre-populate the form
        model.addAttribute("department", department);
        return "html/updateDepartmentPage";
    }

    //---------------------SAVE DATA TO DATABASE -----------

    //    <!-- Add hidden form field to handle update -- >

    //Save user data to database
    @PostMapping("/saveDepartment")
    public String saveDepartment(@ModelAttribute("department")
                                 @Valid Department department,
                                 BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {

            logger.info("/////// IN IF STATEMENT - SAVE UPDATE DEPARTMENT //////// :");
            return "html/addDepartmentPage";
        }
        // save customer to database
        departmentService.saveDepartment(department);
        logger.info("///////  SAVE UPDATE DEPARTMENT //////// :");
        return "redirect:/departmentsListHandler";


    }

//    //-----------------ADD A CUSTOMER TO A DEPARTMENT PROCESS------------------
//
    @GetMapping("/addCustomerToDepartPageHandler/{dId}")
    public String addCustomerToDepartment(@PathVariable int dId, Model model)
    {
        // create model attribute to bind form data
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        model.addAttribute("departmentId", dId);
        return "html/addCustomerToDepartmentPage";
    }

    @PostMapping("/departmentPageHandler/{departmentId}/customerPageHandler")
    public String saveCustomerToDepartment(@PathVariable int departmentId,
                                           Model model,
                                           @ModelAttribute ("customer")
                                           @Valid Customer customer,
                                           BindingResult bindingResult)
    {
        //go get dept  with the departmentId
        Department department = departmentService.getDepartmentById(departmentId);

        if (bindingResult.hasErrors())
        {
            return "html/updateDepartmentPage";
        }

        List<Customer> customerList = department.getCustomerList();
        logger.info("/////// DEPARTMENT ENTITY - ADD CUST TO DEPARTMENT - AFTER LISTING @POSTMAPPING//////// :" + departmentId);

        customerList.add(customer);
        logger.info("/////// DEPARTMENT ENTITY - ADD CUST TO DEPARTMENT - AFTER LISTING ADDING @POSTMAPPING//////// :" + departmentId);

        departmentService.saveDepartment(department);
        logger.info("///////DEPARTMENT ENTITY - ADD CUST TO DEPARTMENT - AFTER ADDING TO DEPARTMENT @POSTMAPPING//////// :" + departmentId);

        return "redirect:/departmentsListHandler";
    }

}//departmentcontroller end






