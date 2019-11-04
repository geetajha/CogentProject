package com.cogent.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.dao.VehicleRepository;
import com.cogent.model.Customers;
import com.cogent.model.ServiceCenter;
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
	public  void deleteVehicle(Integer vId)
	{
		vRepo.deleteById(vId);
	}
	public List<VehicleRegistration> getVehicleByNo(Integer vNum)
	{
		List<VehicleRegistration> vh1 = new ArrayList<VehicleRegistration>();
		List<VehicleRegistration> vh2 = (List<VehicleRegistration>) vRepo.findAll();
		System.out.println("Argument for branchname is"+vNum);
		for(VehicleRegistration vh:vh2)
		{
			if(((VehicleRegistration) vh).getvNum()==vNum)
			{
				System.out.println("vNum"+vh);
				vh1.add(vh);
			}
		}
     System.out.println(vh1);
		return vh1;	
	}
	
	
	
	
}
