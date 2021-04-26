package com.mpuertao.productservice.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mpuertao.productservice.entity.Categorie;
import com.mpuertao.productservice.entity.MessagesError;
import com.mpuertao.productservice.entity.Product;
import com.mpuertao.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> listProduct(@RequestParam(name = "categorieId", required = false) Long categorieId) {
        List<Product> products = new ArrayList<>();
        if (null == categorieId) {
            products = productService.listAllProduct();
            if (products.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
        } else {
            products = productService.findByCategorie(Categorie.builder().id(categorieId).build());
            if (products.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        Product product = productService.getProduct(id);
        if (null == product) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product, BindingResult result) {
        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    private String formatMessage(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String, String> error = new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());

        MessagesError messageError = MessagesError.builder()
                .code("01")
                .messages(errors)
                .build();

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(messageError);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        product.setId(id);
        Product productDB = productService.updateProduct(product);
        if (null == productDB) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) {
        Product productDelete = productService.deleteProduct(id);
        if (null == productDelete) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDelete);
    }

    @GetMapping(value = "/{id}/stock")
    public ResponseEntity<Product> updateStockProduct(@PathVariable("id") Long id, @RequestParam(name = "quantity") Double quantity) {
        Product product = productService.updateStock(id, quantity);
        if (null == product) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }


}
