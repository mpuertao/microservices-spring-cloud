package com.mpuertao.customerservice.service;

import com.mpuertao.customerservice.entity.Customer;
import com.mpuertao.customerservice.entity.Region;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    List<Customer> findAllCustomer();

    List<Customer> findAllCustomerByRegion(Region region);

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    Customer deleteCustomer(Long id);

    Customer getCustomer(Long id);
}
