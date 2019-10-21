package com.cogent.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.dao.CustomerRepository;
import com.cogent.model.Customers;


@Service
public class CustomerService {
	@Autowired
	private CustomerRepository custRepo;
	public Customers getCustomerById(Integer custId)
	{
		Customers cust= custRepo.findById(custId).get();
	
		
		return cust;	
	}
	public List<Customers> getAllCustomer(){
		List<Customers> list = new ArrayList<>();
		 custRepo.findAll().forEach(cust->list.add(cust));
		 //custRepo.findAll();
		return list;
		
	}
	public List<Customers> addAllCustomer(List<Customers> cust){
		List<Customers> list = new ArrayList<>();
		custRepo.saveAll(list);
		return list;
		
		
	}
	public Customers addCustomer(Customers cust){
		custRepo.save(cust);
		return cust;
		
	}
	public void updateCustomer(Customers cust) {
		custRepo.save(cust);
	}
	public void deleteCustomer(Customers cust) {
		custRepo.delete(cust);
	}
	
	

}



