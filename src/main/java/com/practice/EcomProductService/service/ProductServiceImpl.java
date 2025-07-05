package com.practice.EcomProductService.service;

import com.practice.EcomProductService.dto.ProductListResponseDTO;
import com.practice.EcomProductService.dto.ProductRequestDTO;
import com.practice.EcomProductService.dto.ProductResponseDTO;
import com.practice.EcomProductService.mapper.ProductMapper;
import com.practice.EcomProductService.model.Product;
import com.practice.EcomProductService.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        List<Product> products = productRepository.findAll();
        ProductListResponseDTO productListResponseDTO = ProductMapper.convertProductsToProductListResponseDTO(products);
        return productListResponseDTO;
    }

    @Override
    public ProductResponseDTO getProductById(UUID id) {
        Optional<Product> productOptional = productRepository.findById(id);
        Product product = null;
        if (productOptional.isPresent()) {
            product = productOptional.get();
        }
        ProductResponseDTO productResponseDTO = ProductMapper.convertProductToProductResponseDTO(product);
        return productResponseDTO;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO product) {
        return null;
    }

    @Override
    public boolean deleteProduct(int id) {
        return false;
    }

    @Override
    public Product updateProduct(int id, Product updatedProduct) {
        return null;
    }

    @Override
    public ProductResponseDTO findProductByTitle(String title) {
        Product product = productRepository.findByTitle(title);
        ProductResponseDTO productResponseDTO = ProductMapper.convertProductToProductResponseDTO(product);
        return productResponseDTO;
    }
}
