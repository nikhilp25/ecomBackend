package com.practice.EcomProductService.service;

import com.practice.EcomProductService.dto.ProductListResponseDTO;
import com.practice.EcomProductService.dto.ProductRequestDTO;
import com.practice.EcomProductService.dto.ProductResponseDTO;
import com.practice.EcomProductService.model.Product;

public interface ProductService {
    ProductListResponseDTO getAllProducts();
    ProductResponseDTO getProductById(int id);
    ProductResponseDTO createProduct(ProductRequestDTO product);
    boolean deleteProduct(int id);
    Product updateProduct(int id, Product updatedProduct);
}
