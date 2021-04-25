package com.mpuertao.customerservice.service;

import com.mpuertao.customerservice.entity.Customer;
import com.mpuertao.customerservice.entity.Region;
import com.mpuertao.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findAllCustomerByRegion(Region region) {
        return customerRepository.findByRegion(region);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        Customer customerDB = customerRepository.findByNumberId(customer.getNumberId());
        if (customerDB != null) {
            return customerDB;
        }
        customer.setState("CREATED");
        customerDB = customerRepository.save(customer);
        return customerDB;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer customerDB = customerRepository.findById(customer.getId()).orElse(null);
        if (customerDB == null) {
            return null;
        }
        customerDB.setFirstName(customer.getFirstName());
        customerDB.setLastName(customer.getLastName());
        customerDB.setEmail(customer.getEmail());
        customerDB.setRegion(customer.getRegion());

        return customerRepository.save(customerDB);
    }

    @Override
    public Customer deleteCustomer(Long id) {
        Customer customerDB = getCustomer(id);
        if (customerDB == null) {
            return null;
        }
        customerDB.setState("DELETED");
        return customerRepository.save(customerDB);
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
