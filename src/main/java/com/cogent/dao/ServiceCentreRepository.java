package com.cogent.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cogent.model.ServiceCenter;

@Repository
public interface ServiceCentreRepository extends CrudRepository<ServiceCenter, Integer> 
{

}
