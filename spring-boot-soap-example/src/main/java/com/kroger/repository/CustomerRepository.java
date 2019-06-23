package com.kroger.repository;

import java.io.Serializable;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import com.kroger.entity.Customer;

@Repository
public interface CustomerRepository extends CassandraRepository<Customer,Serializable>
{
	
    
   
}
