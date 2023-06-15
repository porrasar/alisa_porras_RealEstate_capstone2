package com.perscholas.RealEstate.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table
//public class Department implements Serializable
public class Department implements Serializable
{

    //-----------------VARIABLES ---------------------------------
    //    private static final long serialVersionUID = 1L;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "Department Id")
    private int departmentId;
    //@Column(name = "Department Name")
    private String departmentName;

    //@Column(name = "Customer IDK")
//    @OneToMany(targetEntity = Department.class, cascade = {CascadeType.ALL})
//    private List departmentList;

    @JoinTable
    @OneToMany(targetEntity = Customer.class, cascade = {CascadeType.ALL})
    private List customerList;
    //----------------------------------CONSTRUCTORS-------------------------



//    public Department(int departmentId, String departmentName, List departmentList)
//    public Department(int departmentId, String departmentName)
//    {
//        this.departmentId = departmentId;
//        this.departmentName = departmentName;
////        this.departmentList = departmentList;
//    }

        public Department(int departmentId, String departmentName)
        {
        super();
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }
    public Department()
    {
    }


//    public Department(int departmentId, String departmentName, List customerList) {
//        this.departmentId = departmentId;
//        this.departmentName = departmentName;
//        this.customerList = customerList;
//    }


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

    public List getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List customerList) {
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

    //    public List getCustomerList() {
//        return departmentList;
//    }
//
//    public void setCustomerList(List departmentList) {
//        this.departmentList = departmentList;
//    }

//    @Override
//    public String toString()
//    {
//        return "Department{" +
//                "departmentId=" + departmentId +
//                ", departmentName='" + departmentName + '\'' +
//                ", customerList=" + departmentList +
//                '}';
//    }
//
//    @Override
//    public String toString()
//    {
//        return "Department{" +
//                "departmentId=" + departmentId +
//                ", departmentName='" + departmentName + '\'' + '}';
//    }

}
