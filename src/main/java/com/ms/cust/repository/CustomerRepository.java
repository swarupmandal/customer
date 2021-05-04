package com.ms.cust.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.cust.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
