package com.practice.EcomProductService.mapper;

import com.practice.EcomProductService.dto.FakeStoreProductRequestDTO;
import com.practice.EcomProductService.dto.FakeStoreProductResponseDTO;
import com.practice.EcomProductService.dto.ProductRequestDTO;
import com.practice.EcomProductService.dto.ProductResponseDTO;

public class ProductMapper {
    public static FakeStoreProductRequestDTO productRequestToFakeStoreProductRequest(ProductRequestDTO productRequestDTO){
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = new FakeStoreProductRequestDTO();
        fakeStoreProductRequestDTO.setCategory(productRequestDTO.getCategory());
        fakeStoreProductRequestDTO.setDescription(productRequestDTO.getDescription());
        fakeStoreProductRequestDTO.setPrice(productRequestDTO.getPrice());
        fakeStoreProductRequestDTO.setImage(productRequestDTO.getImage());
        fakeStoreProductRequestDTO.setTitle(productRequestDTO.getTitle());
        return fakeStoreProductRequestDTO;
    }

    public static ProductResponseDTO fakeProductResponseToProductResponse(FakeStoreProductResponseDTO fakeStoreProductResponseDTO){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setId(fakeStoreProductResponseDTO.getId());
        productResponseDTO.setPrice(fakeStoreProductResponseDTO.getPrice());
        productResponseDTO.setTitle(fakeStoreProductResponseDTO.getTitle());
        productResponseDTO.setDescription(fakeStoreProductResponseDTO.getDescription());
        productResponseDTO.setCategory(fakeStoreProductResponseDTO.getCategory());
        productResponseDTO.setImage(fakeStoreProductResponseDTO.getImage());
        return productResponseDTO;
    }
}
