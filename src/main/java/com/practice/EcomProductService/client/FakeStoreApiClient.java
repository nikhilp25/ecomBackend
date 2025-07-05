package com.practice.EcomProductService.client;

import com.practice.EcomProductService.dto.FakeStoreProductRequestDTO;
import com.practice.EcomProductService.dto.FakeStoreProductResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Component
public class FakeStoreApiClient {
    private RestTemplateBuilder restTemplateBuilder;
    private String fakeStoreAPIURL;
    @Value("${fakestore.api.path.product}")
    private String fakeStoreAPIPathProduct;

    public FakeStoreApiClient(RestTemplateBuilder restTemplateBuilder,@Value("${fakestore.api.url}") String fakeStoreAPIURL){
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIURL=fakeStoreAPIURL;
    }

    public List<FakeStoreProductResponseDTO> getAllProducts(){
        String getAllProducts = fakeStoreAPIURL + fakeStoreAPIPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseArray =
                restTemplate.getForEntity(getAllProducts, FakeStoreProductResponseDTO[].class);
        return List.of(productResponseArray.getBody());
    }

    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO fakeStoreProductRequestDTO){
        String productBaseURL = fakeStoreAPIURL + fakeStoreAPIPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse = restTemplate.postForEntity(productBaseURL, fakeStoreProductRequestDTO,FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }

    public void deleteProduct(int id){
        String productDeleteURL = fakeStoreAPIURL + fakeStoreAPIPathProduct + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(productDeleteURL);
    }

    public FakeStoreProductResponseDTO getProductById(UUID id){
        String getProductByUrlId = fakeStoreAPIURL + fakeStoreAPIPathProduct + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse =
                restTemplate.getForEntity(getProductByUrlId, FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }
}
