package com.josh.practice.redis.controller;

import com.josh.practice.redis.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/redis/product")
public class Controller {
    public static final String HASH_KEY = "Product";
    @Autowired
    @Qualifier("template")
    private RedisTemplate template;

    @PostMapping
    public Product save(@RequestBody Product product) {
        template.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return template.opsForHash().values(HASH_KEY);
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Integer id) {
        return (Product) template.opsForHash().get(HASH_KEY, id);
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable Integer id) {
        template.opsForHash().delete(HASH_KEY, id);
        return "product has been removed!!";
    }

}
