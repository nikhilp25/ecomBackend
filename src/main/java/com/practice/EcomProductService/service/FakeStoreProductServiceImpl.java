package com.practice.EcomProductService.service;

import com.practice.EcomProductService.client.FakeStoreApiClient;
import com.practice.EcomProductService.dto.*;
import com.practice.EcomProductService.model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.practice.EcomProductService.mapper.ProductMapper.fakeProductResponseToProductResponse;
import static com.practice.EcomProductService.mapper.ProductMapper.productRequestToFakeStoreProductRequest;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl implements ProductService{
    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreApiClient fakeStoreAPIClient;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder, FakeStoreApiClient fakeStoreApiClient){
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIClient = fakeStoreApiClient;
    }
    @Override
    public ProductListResponseDTO getAllProducts(){
        List<FakeStoreProductResponseDTO> fakeStoreProductResponseDTOs = fakeStoreAPIClient.getAllProducts();
        ProductListResponseDTO productListResponseDTO = new ProductListResponseDTO();
        for(FakeStoreProductResponseDTO fakeStoreProductResponseDTO:fakeStoreProductResponseDTOs){
            productListResponseDTO.getProducts().add(fakeProductResponseToProductResponse(fakeStoreProductResponseDTO));
        }
        return productListResponseDTO;
    }
    @Override
    public ProductResponseDTO getProductById(int id) {
       FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.getProductById(id);
        ProductResponseDTO productResponseDTO=fakeProductResponseToProductResponse(fakeStoreProductResponseDTO);
       return productResponseDTO;
    }
    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO){
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = productRequestToFakeStoreProductRequest(productRequestDTO);
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.createProduct(fakeStoreProductRequestDTO);
        ProductResponseDTO productResponseDTO=fakeProductResponseToProductResponse(fakeStoreProductResponseDTO);
        return productResponseDTO;
    }
    @Override
    public boolean deleteProduct(int id){
        fakeStoreAPIClient.deleteProduct(id);
       return true;
    }
    @Override
    public Product updateProduct(int id, Product updatedProduct){
        return null;
    }

}
