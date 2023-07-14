package com.perscholas.RealEstate.entities;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;

/*
Purpose: This class is to define the Maintenance entity -  with variables, constructors and getter/setters and using Springboot.
          This creates the table in the database.
*/
@Entity
public class Maintenance implements Serializable
{


    //-----------------VARIABLES ---------------------------------

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mId;


    @NotNull
    @Size(min=1, max=100)
    private String maintenanceName;
//    private String maintenanceWebSite;
//    private String maintenancePhone;
//    private String maintenanceEmail;
//
//    @NotNull
//    private String maintenanceAddress;
//    private String maintenanceCity;
//    private String maintenanceState;
//    private Integer maintenanceZip;
//    private String maintenanceHours;

    //--------------------------CONSTRUCTOR--------------


//    public Maintenance(int mId, String maintenanceWebSite, String maintenanceName, String maintenancePhone, String maintenanceEmail, String maintenanceAddress, String maintenanceCity,
//                       String maintenanceState, Integer maintenanceZip, String maintenanceHours) {
//        this.mId = mId;
//        this.maintenanceWebSite = maintenanceWebSite;
//        this.maintenanceName = maintenanceName;
//        this.maintenancePhone = maintenancePhone;
//        this.maintenanceEmail = maintenanceEmail;
//        this.maintenanceAddress = maintenanceAddress;
//        this.maintenanceCity = maintenanceCity;
//        this.maintenanceState = maintenanceState;
//        this.maintenanceZip = maintenanceZip;
//        this.maintenanceHours = maintenanceHours;
//    }


    public Maintenance(String maintenanceName) {
        this.maintenanceName = maintenanceName;
    }

    public Maintenance() {
    }

    //- ------------------------GETTER/SETTER---------------------


    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }



    public String getMaintenanceName() {
        return maintenanceName;
    }

    public void setMaintenanceName(String maintenanceName) {
        this.maintenanceName = maintenanceName;
    }
//
//    public String getMaintenanceWebSite() {
//        return maintenanceWebSite;
//    }
//
//    public void setMaintenanceWebSite(String maintenanceWebSite) {
//        this.maintenanceWebSite = maintenanceWebSite;
//    }
//    public String getMaintenancePhone() {
//        return maintenancePhone;
//    }
//
//    public void setMaintenancePhone(String maintenancePhone) {
//        this.maintenancePhone = maintenancePhone;
//    }
//
//    public String getMaintenanceEmail() {
//        return maintenanceEmail;
//    }
//
//    public void setMaintenanceEmail(String maintenanceEmail) {
//        this.maintenanceEmail = maintenanceEmail;
//    }
//
//    public String getMaintenanceAddress() {
//        return maintenanceAddress;
//    }
//
//    public void setMaintenanceAddress(String maintenanceAddress) {
//        this.maintenanceAddress = maintenanceAddress;
//    }
//
//    public String getMaintenanceCity() {
//        return maintenanceCity;
//    }
//
//    public void setMaintenanceCity(String maintenanceCity) {
//        this.maintenanceCity = maintenanceCity;
//    }
//
//    public String getMaintenanceState() {
//        return maintenanceState;
//    }
//
//    public void setMaintenanceState(String maintenanceState) {
//        this.maintenanceState = maintenanceState;
//    }
//
//    public Integer getMaintenanceZip() {
//        return maintenanceZip;
//    }
//
//    public void setMaintenanceZip(Integer maintenanceZip) {
//        this.maintenanceZip = maintenanceZip;
//    }
//
//    public String getMaintenanceHours() {
//        return maintenanceHours;
//    }
//
//    public void setMaintenanceHours(String maintenanceHours) {
//        this.maintenanceHours = maintenanceHours;
//    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "mId=" + mId +
                ", maintenanceName='" + maintenanceName + '\'' +
                '}';
    }

//    @Override
//    public String toString() {
//        return "Maintenance{" +
//                "mId=" + mId +
//                ", maintenanceWebSite='" + maintenanceWebSite + '\'' +
//                ", maintenanceName='" + maintenanceName + '\'' +
//                ", maintenancePhone='" + maintenancePhone + '\'' +
//                ", maintenanceEmail=" + maintenanceEmail +
//                ", maintenanceAddress='" + maintenanceAddress + '\'' +
//                ", maintenanceCity='" + maintenanceCity + '\'' +
//                ", maintenanceState='" + maintenanceState + '\'' +
//                ", maintenanceZip=" + maintenanceZip +
//                ", maintenanceHours='" + maintenanceHours + '\'' +
//                '}';
//    }


}
