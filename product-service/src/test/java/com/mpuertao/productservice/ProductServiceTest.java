package com.mpuertao.productservice;

import com.mpuertao.productservice.entity.Categorie;
import com.mpuertao.productservice.entity.Product;
import com.mpuertao.productservice.repository.ProductRepository;
import com.mpuertao.productservice.service.ProductService;
import com.mpuertao.productservice.service.ProductServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        productService = new ProductServiceImpl(productRepository);
        Product pc = Product.builder()
                .id(1L)
                .name("pc")
                .categorie(Categorie.builder().id(1L).build())
                .price(Double.parseDouble("12.5"))
                .stock(Double.parseDouble("5"))
                .build();

        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(pc));
        Mockito.when(productRepository.save(pc))
                .thenReturn(pc);
    }

    @Test
    public void whenValidGetIdThenReturnProduct() {
        Product found = productService.getProduct(1L);
        Assertions.assertThat(found.getName()).isEqualTo("pc");
    }

    @Test
    public void whenValidUpdateStockThenReturnNewStock() {
        Product newStock = productService.updateStock(1L, Double.parseDouble("8"));
        Assertions.assertThat(newStock.getStock()).isEqualTo(13);
    }
}
