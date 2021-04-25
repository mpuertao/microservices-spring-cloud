package com.mpuertao.productservice.repository;

import com.mpuertao.productservice.entity.Categorie;
import com.mpuertao.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategorie(Categorie categorie);
}
