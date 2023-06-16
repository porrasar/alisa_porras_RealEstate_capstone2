package com.perscholas.RealEstate.controllers;


import com.perscholas.RealEstate.entities.Customer;
import com.perscholas.RealEstate.entities.Department;
import com.perscholas.RealEstate.repositories.DepartmentRepository;

import com.perscholas.RealEstate.services.DepartmentService;
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

    //-----------------VARIABLES ---------------------------------
    private DepartmentService departmentService;
    @Autowired
    private DepartmentRepository repository;

    //-----------------CONSTRUCTOR---------------------------------
    @Autowired
    public DepartmentController(DepartmentService departmentService)
    {
        this.departmentService = departmentService;
    }

    //-------------------METHODS -----------------------------------


    //---------------------LIST ALL CUSTOMERS -----------
    //display initial view/html page, list of all customers
    @GetMapping("/departmentsListHandler")
    public String getAllDepartment(Model model)
    {
        List<Department> departments = repository.findAll();
        // the 1st 'departments' is a made up name, for the key, of the key, valued pair of the Model class
        // the 2nd 'departments' is the object variable for the list type
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
            return "html/addDepartmentPage";
        }
        // save customer to database
        departmentService.saveDepartment(department);
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

    @PostMapping("/departmentPageHandler/{dId}/customerPageHandler")
    public String saveCustomerToDepartment(@PathVariable int dId,
                                           Model model,
                                           @ModelAttribute ("customer")
                                           @Valid Customer customer,
                                           BindingResult bindingResult)

    {

        //go get dept  with the did
        Department department = departmentService.getDepartmentById(dId);

        if (bindingResult.hasErrors())
        {
            return "html/updateDepartmentPage";
        }
//         customerService.saveCustomer(customer);

        return "redirect:/departmentsListHandler" + dId;

    }


}//departmentcontroller end






