package com.mpuertao.shoppingservice.client;

import com.mpuertao.shoppingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "product-service")
@RequestMapping(value = "/products")
public interface ProductClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<Product> getProduct(@PathVariable("id") Long id);

    @GetMapping(value = "/{id}/stock")
    ResponseEntity<Product> updateStockProduct(@PathVariable("id") Long id, @RequestParam(name = "quantity", required = true) Double quantity);
}
