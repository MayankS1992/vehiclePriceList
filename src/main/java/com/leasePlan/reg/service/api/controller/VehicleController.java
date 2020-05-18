package com.leasePlan.reg.service.api.controller;

import com.leasePlan.reg.service.api.model.Options;
import com.leasePlan.reg.service.api.model.Vehicle;
import com.leasePlan.reg.service.api.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("vehicles-rest")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    Logger logger = LoggerFactory.getLogger(VehicleController.class);

    @GetMapping("/getAllVehicles")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.findAll();
    }

    @GetMapping("/findVehicle/{id}")
    public Optional<Vehicle> findVehicle(@PathVariable int id) {
        return vehicleService.findVehicle(id);
    }

    @DeleteMapping(value = "/deleteVehicle/{aid}")
    public List<Vehicle> deleteVehicle(@PathVariable String aid) {
        if(vehicleService.findVehicle(Integer.parseInt(aid)).isPresent()){
            logger.debug("Vehicle found, requesting deletion for vehicle id: "+ Integer.parseInt(aid));
            vehicleService.deleteById(Integer.parseInt(aid));
        }
        return vehicleService.findAll();
    }

    @GetMapping(value = "/getOptions/{id}")
    public Optional<Options> getOptions(@PathVariable int id) {
        return vehicleService.getOptions(id);
    }

}
