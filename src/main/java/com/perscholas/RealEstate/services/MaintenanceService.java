package com.perscholas.RealEstate.services;

import com.perscholas.RealEstate.entities.House;
import com.perscholas.RealEstate.entities.Maintenance;

import java.util.List;

public interface MaintenanceService
{
    List<Maintenance> getAllMaintenances();

    void saveMaintenance(Maintenance maintenance);

    Maintenance getMaintenanceById(int id);

//
//    Maintenance getMaintenanceByMaintenanceName(String maintenanceName);

    void deleteMaintenanceById(int id);
}
