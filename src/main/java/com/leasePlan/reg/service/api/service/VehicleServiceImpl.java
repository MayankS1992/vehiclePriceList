package com.leasePlan.reg.service.api.service;

import com.leasePlan.reg.service.api.dao.VehicleRepository;
import com.leasePlan.reg.service.api.model.Options;
import com.leasePlan.reg.service.api.model.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private OptionsRepository optionsRepository;

    Logger logger = LoggerFactory.getLogger(VehicleServiceImpl.class);

    @Override
    public Vehicle save(Vehicle vehicle) {
        logger.debug("Requesting to add a new Vehicle in class: "+ VehicleServiceImpl.class);
        vehicle.setAid((ThreadLocalRandom.current().nextInt()));
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> findAll() {
        logger.debug("Requesting to view all Vehicles in class: "+ VehicleServiceImpl.class);
        return (List<Vehicle>) vehicleRepository.findAll();
    }

    @Override
    public Optional<Vehicle> findVehicle(int id) {
        logger.debug("Requesting to VIEW Vehicle id"+ id + " in class: "+ VehicleServiceImpl.class);
        return vehicleRepository.findById(id);
    }

    @Override
    public Boolean deleteById(int id) {
        logger.debug("Requesting to DELETE Vehicle id"+ id + " in class: "+ VehicleServiceImpl.class);
        vehicleRepository.deleteById(id);
        if(optionsRepository.findById(id)!=null){
            optionsRepository.deleteById(id);
        }
        return !vehicleRepository.findById(id).isPresent();
    }

    @Override
    public Optional<Options> getOptions(int id) {
        return optionsRepository.findById(id);
    }
}
