package com.mpuertao.customerservice.repository;

import com.mpuertao.customerservice.entity.Customer;
import com.mpuertao.customerservice.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByNumberId(String numberId);

    List<Customer> findByRegion(Region region);
}
