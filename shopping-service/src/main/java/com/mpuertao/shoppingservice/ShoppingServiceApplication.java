package com.mpuertao.shoppingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableHystrix
@EnableHystrixDashboard
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class ShoppingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingServiceApplication.class, args);
    }

}
