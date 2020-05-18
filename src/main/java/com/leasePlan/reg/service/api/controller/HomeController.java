package com.leasePlan.reg.service.api.controller;

import com.leasePlan.reg.service.api.model.Vehicle;
import com.leasePlan.reg.service.api.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    private VehicleService vehicleService;

    Logger logger = LoggerFactory.getLogger(VehicleController.class);

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/addVehicle", method = RequestMethod.POST)
    public String addVehicle(Vehicle vehicle) {
        logger.debug("Adding vehicle");
        if (vehicleService.save(vehicle)!=null) {
            return "home";
        }else{
            return "failed";
        }
    }


}
