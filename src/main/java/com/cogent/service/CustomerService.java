package com.cogent.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.dao.CustomerRepository;
import com.cogent.model.Customers;
import com.cogent.model.ServiceCenter;


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
	public void deleteCustomer(Integer cuId) {
		custRepo.deleteById(cuId);
	}
	public List<Customers> getCustomerByCustomerName(String customerName)
	{
		List<Customers> custs = new ArrayList<Customers>();
		List<Customers> customer = (List<Customers>) custRepo.findAll();
		System.out.println("Argument for branchname is"+customerName);
		for(Customers c:customer)
		{
			if(c.getCuName().contains(customerName))
			{
				System.out.println("Customers"+c);
				custs.add(c);
			}
		}
     System.out.println(custs);
		return custs;	
	}
	
	
	}





