package com.practice.EcomProductService.controller;

import com.practice.EcomProductService.dto.ProductListResponseDTO;
import com.practice.EcomProductService.dto.ProductRequestDTO;
import com.practice.EcomProductService.dto.ProductResponseDTO;
import com.practice.EcomProductService.exception.ProductNotFoundException;
import com.practice.EcomProductService.model.Product;
import com.practice.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ProductController {
    @Autowired
    @Qualifier("ProductService")
    private ProductService productService;
    @GetMapping("/product")
    public ResponseEntity getAllProduct(){
        ProductListResponseDTO responseDTO = productService.getAllProducts();
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity getProductFromId(@PathVariable("id") UUID id) throws ProductNotFoundException {
        ProductResponseDTO response = productService.getProductById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/product")
    public ResponseEntity createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO response = productService.createProduct(productRequestDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") int id){
        boolean response = productService.deleteProduct(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product/title/{title}")
    public ResponseEntity getProductByTitle(@PathVariable("title") String title){
        ProductResponseDTO responseDTO = productService.findProductByTitle(title);
        return ResponseEntity.ok(responseDTO);
    }
}
