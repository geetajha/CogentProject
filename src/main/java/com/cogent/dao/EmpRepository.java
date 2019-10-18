package com.cogent.dao;

import org.springframework.data.repository.CrudRepository;

import com.cogent.model.Employee;

public interface EmpRepository extends CrudRepository<Employee,Integer>{

}
