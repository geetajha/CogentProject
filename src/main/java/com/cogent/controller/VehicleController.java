package com.cogent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cogent.model.VehicleRegistration;
import com.cogent.service.Vehicleservice;



@RequestMapping("/vehicle")
@RestController
public class VehicleController {
	@Autowired
	private Vehicleservice vser;
	@GetMapping(("/{vid}"))
	public ResponseEntity <VehicleRegistration> getVehicleById(@PathVariable("vid") Integer vid)
	{
		VehicleRegistration vehicles = vser.getVehicleById(vid);
		
		return new ResponseEntity<VehicleRegistration>(vehicles,HttpStatus.OK);

}
	@GetMapping("/all")
	public ResponseEntity <List<VehicleRegistration>> getAllVehicle()
	{
		List<VehicleRegistration> lvr = vser.getAllVehicle();
		return new ResponseEntity<>(lvr,HttpStatus.OK);
		
	}
	@PostMapping("/add")
    public ResponseEntity <VehicleRegistration> addVehicle(@RequestBody VehicleRegistration addvrg, UriComponentsBuilder builder) {
		VehicleRegistration vrg = vser.addVehicle(addvrg);;	        
        return new ResponseEntity<>(vrg,HttpStatus.OK);
    }

@PutMapping("/update")
public ResponseEntity <VehicleRegistration> updateVehicle(@RequestBody VehicleRegistration upvrg, UriComponentsBuilder builder) {
	VehicleRegistration vrg = vser.updateVehicle(upvrg);	        
    return new ResponseEntity<>(vrg,HttpStatus.OK);
}
@DeleteMapping("/delete")
public ResponseEntity <VehicleRegistration> deleteVehicle(@RequestBody VehicleRegistration delvrg, UriComponentsBuilder builder) {
	   
	vser.deleteVehicle(delvrg);
	return null;   
    
}
}
