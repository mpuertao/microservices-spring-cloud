package com.mpuertao.productservice;

import com.mpuertao.productservice.entity.Categorie;
import com.mpuertao.productservice.entity.Product;
import com.mpuertao.productservice.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFindByCategoryThenReturnListProduct() {

        //Arrange
        Product product = Product.builder()
                .categorie(Categorie.builder().id(1L).build())
                .description("DESCRIPTION #1")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("1000.15"))
                .status("Created")
                .createAt(new Date())
                .build();

        // Act
        productRepository.save(product);
        List<Product> founds = productRepository.findByCategorie(product.getCategorie());

        //Assert
        Assertions.assertThat(founds.size()).isEqualTo(3);
    }
}
