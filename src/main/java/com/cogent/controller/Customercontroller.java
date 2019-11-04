package com.cogent.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.util.UriComponentsBuilder;

import com.cogent.model.Customers;
import com.cogent.service.CustomerService;

/**
 * @author Geeta
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/customer")
@RestController
public class Customercontroller {
	
	    @Autowired
	    private CustomerService custService;
	    
	    @GetMapping("/{cuId}")
	    public ResponseEntity <Customers>getCustomerById(@PathVariable("cuId") Integer cuId) {
	    	Customers cust = custService.getCustomerById(cuId);
	        
	        return new ResponseEntity<Customers>(cust,HttpStatus.OK);
	    }
	    
	    @GetMapping("/searchcust")
	    public ResponseEntity <List<Customers>>getAllCustomer() {
	    	List<Customers> cust = custService.getAllCustomer();
	    	System.out.println("got request "+cust.size());
	        return new ResponseEntity<>(cust,HttpStatus.OK);
	    }
	    @PostMapping("/insertcust")
	       public ResponseEntity<Void> Customer(@RequestBody Customers cust, UriComponentsBuilder builder){
	        Customers flag = custService.addCustomer(cust);
	        if(flag==null)
	           return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        System.out.println("value inserted");
	        HttpHeaders header = new HttpHeaders();
	        header.setLocation(builder.path("/customer")
	                .buildAndExpand(cust.getCuId()).toUri());
	        return new ResponseEntity<Void>(header, HttpStatus.CREATED);
	    }
	    @DeleteMapping("/deletecust/{cuId}")
	    public ResponseEntity <List<Customers>>   deleteCustomers(@PathVariable("cuId")Integer cuId){
	    		
	    custService.deleteCustomer(cuId);
	    List<Customers> cust = custService.getAllCustomer();
	    return new ResponseEntity<>(cust,HttpStatus.OK);
	    }
	
  @PutMapping("/updatecust/{id}")
  public ResponseEntity<Customers>updateEmployee(@PathVariable(value = "cuId") Integer cuId, @RequestBody Customers customerDetails) throws
  ResourceAccessException { Customers customers =
  custService.getCustomerById(cuId);
  System.out.println("CALLING UPDATE");
  
  customers.setCuId(customerDetails.getCuId());
  customers.setCuName(customerDetails.getCuName());
  customers.setCuAdd(customerDetails.getCuAdd()); 
  customers.setCuEmail(customerDetails.getCuEmail()); 
  customers.setCuPhone(customerDetails.getCuPhone()); 
  
  
  return new ResponseEntity<Customers>(customers, HttpStatus.OK);
  }
  @GetMapping("/searchCustomerName/{customerName}")   
  public ResponseEntity <List<Customers>> getCustomerByCustomerName(@PathVariable("customerName") String customerName) {
	 System.out.println("Your Customer Name Is"+customerName);
	 List<Customers> cust = custService.getCustomerByCustomerName(customerName);
      System.out.println("Calling BY CustomerName"+cust);
      return new ResponseEntity <>(cust,HttpStatus.OK);
  }
   
  }
  
 

