package com.cogent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cogent.model.Customers;
import com.cogent.model.ServiceCenter;
import com.cogent.model.VehicleRegistration;
import com.cogent.service.Vehicleservice;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/vehicle")
@RestController
public class VehicleController {
	@Autowired
	private Vehicleservice vser;
	@GetMapping(("/{vId}"))
	public ResponseEntity <VehicleRegistration> getVehicleById(@PathVariable("vid") Integer vid)
	{
		VehicleRegistration vehicles = vser.getVehicleById(vid);
		
		return new ResponseEntity<VehicleRegistration>(vehicles,HttpStatus.OK);

}
	@GetMapping("/searchvehicle")
	public ResponseEntity <List<VehicleRegistration>> getAllVehicles()
	{
		List<VehicleRegistration> lvr = vser.getAllVehicle();
		return new ResponseEntity<>(lvr,HttpStatus.OK);
		
	}
	/*
	 * @PostMapping("/insertvehicle") public ResponseEntity <VehicleRegistration>
	 * addVehicle(@RequestBody VehicleRegistration addvrg, UriComponentsBuilder
	 * builder) { VehicleRegistration vrg = vser.addVehicle(addvrg);; return new
	 * ResponseEntity<>(vrg,HttpStatus.OK); }
	 */

@PutMapping("/updatevehicle/")
public ResponseEntity <VehicleRegistration> updateVehicle(@RequestBody VehicleRegistration upvrg, UriComponentsBuilder builder) {
	VehicleRegistration vrg = vser.updateVehicle(upvrg);	        
    return new ResponseEntity<>(vrg,HttpStatus.OK);
}
@DeleteMapping("/deletevehicle/{vId}")
public ResponseEntity <List<VehicleRegistration>> deleteVehicle(@PathVariable("vId")Integer vId) {
	   
	vser.deleteVehicle(vId);
	List<VehicleRegistration> vcle = vser.getAllVehicle();
	return new ResponseEntity<>(vcle,HttpStatus.OK);  
    
}



@PostMapping("/insertvehicle")
public ResponseEntity<Void> VehicleRegistration(@RequestBody VehicleRegistration veh, UriComponentsBuilder builder){
	VehicleRegistration flag = vser.addVehicle(veh);
	System.out.println("value inserted"+veh.toString());
 if(flag==null)
    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
 System.out.println("value inserted");
 HttpHeaders header = new HttpHeaders();
 header.setLocation(builder.path("/vehicle")
         .buildAndExpand(veh.getvId()).toUri());
 return new ResponseEntity<Void>(header, HttpStatus.CREATED);
}
@GetMapping("searchVehicleNo/{vNum}")
public ResponseEntity <List<VehicleRegistration>> getVehicleName(@PathVariable("vNum") Integer vNum) {
 System.out.println("Your Branch Name Is"+vNum);
 List<VehicleRegistration> vReg = vser.getVehicleByNo(vNum);
    System.out.println("Calling BY BranchName"+vReg);
    return new ResponseEntity <>(vReg,HttpStatus.OK);
}
 


}




