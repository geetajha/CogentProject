package com.cogent.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cogent.model.Customers;
@Repository
public interface CustomerRepository  extends CrudRepository<Customers,Integer> 
{

}
