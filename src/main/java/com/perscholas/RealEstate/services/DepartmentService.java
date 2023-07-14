package com.perscholas.RealEstate.services;

import com.perscholas.RealEstate.entities.Department;

import java.util.List;

/*
Purpose: This class defines the business logic methods that perform CRUD and other custom operations.
 */

public interface DepartmentService
{

    List<Department> getAllDepartments();

    void saveDepartment(Department department);

    Department getDepartmentById(int id);

//////
//////    Department getDepartmentByName(String name);

    void deleteDepartmentById(int id);
}
