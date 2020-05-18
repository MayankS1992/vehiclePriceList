package com.leasePlan.reg.service.api.dao;

import com.leasePlan.reg.service.api.model.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle,Integer> {
}
