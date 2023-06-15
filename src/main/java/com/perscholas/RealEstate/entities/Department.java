package com.perscholas.RealEstate.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department implements Serializable
{

    //-----------------VARIABLES ---------------------------------
     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "Department Id")
    private int departmentId;
    //@Column(name = "Department Name")
    private String departmentName;

    @OneToMany(cascade = {CascadeType.ALL})
    private List <Customer> customerList;

    //----------------------------------CONSTRUCTORS-------------------------

        public Department(int departmentId, String departmentName)
        {
        super();
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }
    public Department()
    {
    }

    //- ------------------------GETTER/SETTER---------------------

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", customerList=" + customerList +
                '}';
    }

}
