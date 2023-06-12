//package com.perscholas.alisa_porras_RealEstate_capstone2.controllers;
//
//
//import com.perscholas.alisa_porras_RealEstate_capstone2.entities.Department;
//import com.perscholas.alisa_porras_RealEstate_capstone2.entities.Customer;
//import com.perscholas.alisa_porras_RealEstate_capstone2.repositories.CustomerRepository;
//import com.perscholas.alisa_porras_RealEstate_capstone2.services.CustomerService;
//import com.perscholas.alisa_porras_RealEstate_capstone2.repositories.DepartmentRepository;
//
//import com.perscholas.alisa_porras_RealEstate_capstone2.services.DepartmentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@Controller
//public class DepartmentController
//{
//    //-----------------VARIABLES ---------------------------------
//    private DepartmentService departmentService;
//    @Autowired
//    private DepartmentRepository repository;
//
//    //-----------------CONSTRUCTOR---------------------------------
//    @Autowired
//    public DepartmentController(DepartmentService departmentService)
//    {
//        this.departmentService = departmentService;
//    }
//
//    //-------------------METHODS -----------------------------------
//
//    //display initial view/html page, list of all customers
//    @GetMapping("/")
//    public String getAllDepartment(Model model)
//    {
//        List<Department> departments = repository.findAll();
//        model.addAttribute("department", departments);
//        return "html/departments";
//    }
//
//
////    //Add a new customer
////    @GetMapping("/addNewDepartmentForm")
////    public String addNewDepartmentForm(Model model)
////    {
////        // create model attribute to bind form data
////        Department department = new Department();
////        model.addAttribute("department", department);
////        return "html/addDepartmentPage";
////    }
////
////    @GetMapping("/deleteDepartmentPage/{id}")
////    public String deleteDepartmentPage(@PathVariable(value = "id") int id)
////    {
////        // call delete department method
////        this.departmentService.deleteDepartmentById(id);
////        return "redirect:/";
////    }
////
////
////    @GetMapping("/updateDepartmentPage/{id}")
////    public String updateDepartmentPage(@PathVariable(value = "id") int id, Model model)
////    {
////        // get department from the service
////        Department department = departmentService.getDepartmentById(id);
////
////        // set department as a model attribute to pre-populate the form
////        model.addAttribute("department", department);
////        return "html/updateDepartmentPage";
////    }
////
////    //Save user data to database
////    @PostMapping("/saveDepartment")
////    public String saveDepartment(@ModelAttribute("department") @Valid Department department,
////                               BindingResult bindingResult)
////    {
////        if (bindingResult.hasErrors())
////        {
////            return "html/addDepartmentPage";
////        }
////        // save customer to database
////        departmentService.saveDepartment(department);
////        return "redirect:/";
////    }
//
//}//departmentcontroller end
//
//
//
//
//
//
