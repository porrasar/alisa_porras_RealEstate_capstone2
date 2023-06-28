package com.perscholas.RealEstate.services;

import com.perscholas.RealEstate.entities.House;
import com.perscholas.RealEstate.entities.Maintenance;
import com.perscholas.RealEstate.repositories.HouseRepository;
import com.perscholas.RealEstate.repositories.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl implements MaintenanceService
{
    //-----------------------------VARIABLES-------------------------------------
    private MaintenanceRepository maintenanceRepository;
    private Maintenance maintenance;

    //-----------------------------CONSTRUCTOR-------------------------------------
    @Autowired
    public MaintenanceServiceImpl(MaintenanceRepository maintenanceRepository)
    {
        this.maintenanceRepository = maintenanceRepository;
    }


    //-----------------------------METHODS------------------------------------
    @Override
    public List<Maintenance> getAllMaintenances()
    {
        return maintenanceRepository.findAll();
    }


    @Override
    public void saveMaintenance(Maintenance maintenance)
    {
        maintenanceRepository.save(maintenance);

    }


    /**
     * Returns a Maintenance object based on id argument.
     * <p>
     * Some more description of the method.
     *
     * @param  id  id of an maintenance
     * @return      maintenance object
     */
    @Override
    public Maintenance getMaintenanceById(int id)
    {

        Optional<Maintenance> optionalMaintenance = maintenanceRepository.findById(id);
        if (optionalMaintenance.isPresent())
        {
           Maintenance maintenance = optionalMaintenance.get();
            return maintenance;
        }
        throw new MaintenanceNotFoundException();
    }


    @Override
    public void deleteMaintenanceById(int id)
    {
        maintenanceRepository.deleteById(id);
    }


    //    @Override
//    public House getHouseByAddress(String houseAddress)
//    {
//        House house = houseRepository.findFirstByhouseAddress(houseAddress);
//        if (house == null) {
//            throw new HouseNotFoundException();
//        }
//        return house;
//    }
//

}
