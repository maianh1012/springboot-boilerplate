package com.javalearning.library.repository;

import com.javalearning.library.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
        //create product
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku("A001");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImgUrl("product1.png");

        //Save product
        Product saveObject = productRepository.save(product);

        //display product info
        System.out.println(saveObject.getId());
        System.out.println(saveObject.toString());
    }

    @Test
    void updateUsingSaveMethod(){
        //find an entity by id
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        //update entity information
        product.setName("updated product 1");
        product.setDescription(("updated product 1 description"));

        //save updated entity
        productRepository.save(product);
    }

    @Test
    void findByIdMethod(){
        Long id = 1L;
        Product product = productRepository.findById(id).get();
    }
}