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
import com.cogent.model.Employee;
import com.cogent.service.EmpService;
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employee")
@RestController
public class EmployeeController {
	@Autowired
    private EmpService empService;
	 @GetMapping("/{empId}")
	    public ResponseEntity <Employee>getEmployeeById(@PathVariable("empId") Integer empId) {
	    	Employee emp = empService.getEmployeeById(empId);
	        
	        return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	    }
	 @GetMapping("/searchemployee")
	    public ResponseEntity <List<Employee>>getAllEmployee() {
	    	List<Employee> emp = empService.getAllEmployee();	        
	        return new ResponseEntity<>(emp,HttpStatus.OK);
	    }
	 @PostMapping("/insertemployee")
     public ResponseEntity<Void> Employee(@RequestBody Employee emp, UriComponentsBuilder builder){
      Employee flag = empService.addEmployee(emp);
      if(flag==null)
         return new ResponseEntity<Void>(HttpStatus.CONFLICT);
      HttpHeaders header = new HttpHeaders();
      header.setLocation(builder.path("/employee")
              .buildAndExpand(emp.getEmpId()).toUri());
      return new ResponseEntity<Void>(header, HttpStatus.CREATED);
  }
	 
	 
	 @PutMapping("/update")
	    public ResponseEntity<Employee>    updateEmployee(@RequestBody Employee emp){
	    empService.updateEmployee(emp);
	     return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	     
	 }

	    @DeleteMapping("/delete/{empId}")
	    public ResponseEntity <List<Employee>>   deleteEmployee(@PathVariable("empId")Integer empId){
	    		
	    empService.deleteEmployee(empId);
	   empService.deleteEmployee(empId);
	    return new ResponseEntity<>(HttpStatus.OK);
	    
	     
	 }

}
