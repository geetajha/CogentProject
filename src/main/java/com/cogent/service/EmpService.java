package com.cogent.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cogent.dao.EmpRepository;
import com.cogent.model.Customers;
import com.cogent.model.Employee;

@Service
public class EmpService {
	@Autowired
	private EmpRepository empRepo;
	public Employee getEmployeeById(Integer Id)
	{
		Employee emp = empRepo.findById(Id).get();
		return emp;
	}
	public List<Employee> getAllEmployee(){
		List<Employee> list = new ArrayList<>();
		 empRepo.findAll().forEach(emp->list.add(emp));
		
		return list;
		
	}
	public Employee addEmployee(Employee emp){
		empRepo.save(emp);
		return emp;
		
	}
	public void updateEmployee(Employee emp) {
		empRepo.save(emp);
	}
	
	

}
