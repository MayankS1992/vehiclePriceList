package com.leasePlan.reg.service.api.service;

import com.leasePlan.reg.service.api.model.Options;
import com.leasePlan.reg.service.api.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {

    Vehicle save(Vehicle vehicle);

    List<Vehicle> findAll();

    Optional<Vehicle> findVehicle(int id);

    Boolean deleteById(int id);

    Optional<Options> getOptions(int id);
}
