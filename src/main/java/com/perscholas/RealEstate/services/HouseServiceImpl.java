package com.perscholas.RealEstate.services;

import com.perscholas.RealEstate.entities.House;
import com.perscholas.RealEstate.repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseServiceImpl implements HouseService
{
    //-----------------------------VARIABLES-------------------------------------
    private HouseRepository houseRepository;
    private House house;

    //-----------------------------CONSTRUCTOR-------------------------------------
    @Autowired
    public HouseServiceImpl(HouseRepository houseRepository)
    {
        this.houseRepository = houseRepository;
    }


    //-----------------------------METHODS------------------------------------
    @Override
    public List<House> getAllHouses()
    {
        return houseRepository.findAll();
    }


    @Override
    public void saveHouse(House house)
    {
        houseRepository.save(house);

    }


    /**
     * Returns a House object based on id argument.
     * <p>
     * Some more description of the method.
     *
     * @param  id  id of an employee
     * @return      Employee object
     */
    @Override
    public House getHouseById(int id)
    {

        Optional<House> optionalHouse = houseRepository.findById(id);
        if (optionalHouse.isPresent())
        {
            House house = optionalHouse.get();
            return house;
        }
        throw new HouseNotFoundException();
    }


    @Override
    public void deleteHouseById(int id)
    {
        houseRepository.deleteById(id);
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
