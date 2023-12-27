package com.javalearning.library.controller;

import com.javalearning.library.entity.Product;
import com.javalearning.library.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping(path="/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping(path="/add") //
    public @ResponseBody String addNewProduct (@RequestParam String name
            , @RequestParam String description, @RequestParam String sku, @RequestParam BigDecimal price, @RequestParam Boolean active, @RequestParam String imgUrl) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setSku(sku);
        product.setPrice(price);
        product.setActive(active);
        product.setImgUrl(imgUrl);

        productRepository.save(product);
        return "saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Product> getAllProducts() {
        // This returns a JSON or XML with the users
        return productRepository.findAll();
    }
}
