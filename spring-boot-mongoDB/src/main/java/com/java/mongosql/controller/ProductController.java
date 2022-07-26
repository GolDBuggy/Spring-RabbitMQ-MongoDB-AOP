package com.java.mongosql.controller;

import com.java.mongosql.Repository.ProductRepository;
import com.java.mongosql.config.MessageConfig;
import com.java.mongosql.entity.Product;
import com.java.mongosql.entity.ProductStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    private final RabbitTemplate rabbitTemplate;



    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(productRepository.findAll());
    }

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product){
        product.setId(UUID.randomUUID().toString());
        ProductStatus status=new ProductStatus(product,"process","product placed successfully!");
        rabbitTemplate.convertAndSend(MessageConfig.exchange,MessageConfig.routingKey,status);
        productRepository.save(product);
        return product;
    }

    @GetMapping("/{name}")
    public Product getProduct(@PathVariable String name){

        Product product= productRepository.findByName(name);

        if(product == null) {
            throw new RuntimeException("Product not found!");
        }
        else{
            ProductStatus status=new
                    ProductStatus(product,"process","product name getted successfully");
        rabbitTemplate.convertAndSend(MessageConfig.exchange,MessageConfig.routingKey);
        }
        return product;
    }

    @PutMapping("/update")
    public Product update(@RequestBody Product product){
        productRepository.save(product);
        return  product;
    }

    @DeleteMapping("/delete/{name}")
    public String deleteByName(@PathVariable String name){

        if(name == null) {
            throw new RuntimeException("Product not found!");
        }

        productRepository.deleteByName(name);
        return "User deleted successfully "+name;
    }
}
