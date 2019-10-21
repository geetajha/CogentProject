package com.cogent.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cogent.model.VehicleRegistration;
@Repository
public interface VehicleRepository extends CrudRepository<VehicleRegistration,Integer >{

}
