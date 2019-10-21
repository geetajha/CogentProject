package com.cogent.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.dao.VehicleRepository;
import com.cogent.model.Customers;
import com.cogent.model.VehicleRegistration;

@Service
public class Vehicleservice {
	@Autowired
	VehicleRepository vRepo;
	public VehicleRegistration getVehicleById(Integer id) {
		VehicleRegistration vrg = vRepo.findById(id).get();
		return vrg;
	}
	public List<VehicleRegistration> getAllVehicle(){
		List<VehicleRegistration> vlist = new ArrayList<>();
		 vRepo.findAll().forEach(vehicle->vlist.add(vehicle));
		return vlist;
	}
	public VehicleRegistration addVehicle(VehicleRegistration vrg)
	{
		return vRepo.save(vrg);
	}
	public VehicleRegistration updateVehicle(VehicleRegistration vrg)
	{
		return vRepo.save(vrg);
	}
	public  void deleteVehicle(VehicleRegistration vrg)
	{
		vRepo.delete(vrg);
	}
	
	
	
}
