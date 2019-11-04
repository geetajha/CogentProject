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
import com.cogent.service.ServiceCenterService;
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/branches")
@RestController
public class ServiceCenterController {
	@Autowired
    private ServiceCenterService sercenService;
	 @GetMapping("/{branchId}")
	    public ResponseEntity <ServiceCenter>getSerCenById(@PathVariable("branchId") Integer branchId) {
		 ServiceCenter sercen = sercenService.getBranchById(branchId);
	        
	        return new ResponseEntity<ServiceCenter>(sercen,HttpStatus.OK);
	    }
	 @GetMapping("/allbranch")
	    public ResponseEntity <List<ServiceCenter>>getAllBranches() {
		 
	    	List<ServiceCenter> sercen = sercenService.getAllServiceCenter();	        
	        return new ResponseEntity<>(sercen,HttpStatus.OK);
	    }
	  
	 @PostMapping("/insertbranch")
     public ResponseEntity<Void> ServiceCenter(@RequestBody ServiceCenter sercen, UriComponentsBuilder builder){
     ServiceCenter flag = sercenService.addServiceCenter(sercen);
      if(flag==null)
         return new ResponseEntity<Void>(HttpStatus.CONFLICT);
      HttpHeaders header = new HttpHeaders();
      header.setLocation(builder.path("/branches")
              .buildAndExpand(sercen.getBranchId()).toUri());
      return new ResponseEntity<>(header, HttpStatus.CREATED);
  }
	 @PutMapping("/updatebranch")
	    public ResponseEntity<ServiceCenter>    updateBranches(@RequestBody ServiceCenter sercen){
		 sercenService.updateServiceCenter(sercen);
	     return new ResponseEntity<>(sercen, HttpStatus.OK);
	     
	 }
	 @DeleteMapping("/deletebranch/{brId}")
	    public ResponseEntity <List<ServiceCenter>>   deleteBranches(@PathVariable("brId")Integer brId){
	    		
		 sercenService.deleteBranch(brId);
		 List<ServiceCenter> sercen = sercenService.getAllServiceCenter();
	    return new ResponseEntity<>(sercen,HttpStatus.OK);
	    
	     
	 }
	 
	 
	 @GetMapping("searchBranch/{branchName}")
	    public ResponseEntity <List<ServiceCenter>> getBranchByBranchName(@PathVariable("branchName") String branchName) {
		 System.out.println("Your Branch Name Is"+branchName);
		 List<ServiceCenter> sercen = sercenService.getBranchByBranchName(branchName);
	        System.out.println("Calling BY BranchName"+sercen);
	        return new ResponseEntity <>(sercen,HttpStatus.OK);
	    }
	     
	 

}
