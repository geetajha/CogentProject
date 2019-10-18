package com.cogent.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cogent.dao.ServiceCentreRepository;
import com.cogent.model.Employee;
import com.cogent.model.ServiceCenter;

@Service
public class ServiceCenterService {
	@Autowired
	private ServiceCentreRepository serviceRepo;
	public ServiceCenter getBranchById(Integer serviceId)
	{
		ServiceCenter sercen= serviceRepo.findById(serviceId).get();
	
		
		return sercen;	
	}
	public List<ServiceCenter> getAllServiceCenter(){
		List<ServiceCenter> list = new ArrayList<>();
		serviceRepo.findAll().forEach(sercen->list.add(sercen));
		 
		return list;
		
	}
	public ServiceCenter addServiceCenter(ServiceCenter sercen){
		serviceRepo.save(sercen);
		return sercen;
		
	}
	public void updateServiceCenter(ServiceCenter sercen) {
		serviceRepo.save(sercen);
	}
	public void deleteBranch(Integer prdId) {
		serviceRepo.deleteById(prdId);
	}
	
	}
	

	


