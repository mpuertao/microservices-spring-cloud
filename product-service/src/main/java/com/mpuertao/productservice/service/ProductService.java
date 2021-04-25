package com.mpuertao.productservice.service;

import com.mpuertao.productservice.entity.Categorie;
import com.mpuertao.productservice.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> listAllProduct();

    Product getProduct(Long id);

    Product createProduct(Product product);

    Product updateProduct(Product product);

    List<Product> findByCategorie(Categorie categorie);

    Product updateStock(Long id, Double quantity);

    Product deleteProduct(Long id);
}
