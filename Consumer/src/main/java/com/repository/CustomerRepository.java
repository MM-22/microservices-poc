package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Modifying
	@Query(value = "insert into errorlog (error_type, error_description, payload) values (:error_type, :error_description, :payload)", nativeQuery = true)
	void insertErrorLog(@Param("error_type") String error_type, @Param("error_description") String error_description,
			@Param("payload") String payload);
	
	@Modifying
	@Query(value = "insert into auditlog (customer_number, payload) values (:customer_number, :payload)", nativeQuery = true)
	void insertAuditLog(@Param("customer_number") String customerNumber, @Param("payload") String payload);

}
