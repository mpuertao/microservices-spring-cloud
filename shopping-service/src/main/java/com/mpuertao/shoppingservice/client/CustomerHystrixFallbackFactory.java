package com.mpuertao.shoppingservice.client;

import com.mpuertao.shoppingservice.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerHystrixFallbackFactory implements CustomerClient{
    @Override
    public ResponseEntity<Customer> getCustomer(Long id) {
        Customer customer = Customer.builder()
                .firstName("hystrix")
                .lastName("hystrix")
                .email("hystrix")
                .build();
        return ResponseEntity.ok(customer);
    }
}
