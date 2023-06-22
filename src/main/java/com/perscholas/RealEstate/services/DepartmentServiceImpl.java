package com.perscholas.RealEstate.services;


import com.perscholas.RealEstate.entities.Department;
import com.perscholas.RealEstate.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements com.perscholas.RealEstate.services.DepartmentService
{
    //-----------------------------VARIABLES-------------------------------------
    private DepartmentRepository departmentRepository;
    private Department department;

    //-----------------------------CONSTRUCTOR-------------------------------------
    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository)
    {
        this.departmentRepository = departmentRepository;
    }


    //-----------------------------METHODS------------------------------------
    @Override
    public List<Department> getAllDepartments()
    {
        return departmentRepository.findAll();
    }


    @Override
    public void saveDepartment(Department department)
    {
        departmentRepository.save(department);
    }


    /**
     * Returns an Employee object based on id argument.
     * <p>
     * Some more description of the method.
     *
     * @param  id  id of an employee
     * @return      Employee object
     */
    @Override
    public Department getDepartmentById(int id)
    {

        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isPresent())
        {
            Department department = optionalDepartment.get();
            return department;
        }
        throw new DepartmentNotFoundException();
    }

    //    @Override
//    public Customer getCustomerByName(String name)
//    {
//        Customer employee = customerRepository.findFirstByName(name);
//        if (employee == null) {
//            throw new CustomerNotFoundException();
//        }
//        return employee;
//    }
//
    @Override
    public void deleteDepartmentById(int id)
    {
        departmentRepository.deleteById(id);
    }

}
