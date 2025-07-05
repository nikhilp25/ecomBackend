package com.practice.EcomProductService.service;

import com.practice.EcomProductService.dto.ProductListResponseDTO;
import com.practice.EcomProductService.dto.ProductRequestDTO;
import com.practice.EcomProductService.dto.ProductResponseDTO;
import com.practice.EcomProductService.model.Product;

import java.util.UUID;

public interface ProductService {
    ProductListResponseDTO getAllProducts();
    ProductResponseDTO getProductById(UUID id);
    ProductResponseDTO createProduct(ProductRequestDTO product);
    boolean deleteProduct(int id);
    Product updateProduct(int id, Product updatedProduct);
    ProductResponseDTO findProductByTitle(String title);
}
