package com.cogent.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cogent.model.Employee;
@Repository
public interface EmpRepository extends CrudRepository<Employee,Integer>{

}
