package com.kroger.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Consistency;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.ConsistencyLevel;
import com.kroger.entity.Customer;

@Repository
public interface CustomerRepository extends CassandraRepository<Customer, Long> {

	@Consistency(ConsistencyLevel.LOCAL_QUORUM)
	Optional<Customer> findByCustomerId(Long customerId);

	@Query("select * from customer")
	List<Customer> findAll();

}
