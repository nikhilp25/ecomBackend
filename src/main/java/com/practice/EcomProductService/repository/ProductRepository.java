package com.practice.EcomProductService.repository;

import com.practice.EcomProductService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findByTitle(String title);
    Product findByTitleAndDescription(String title, String description);
    Product findByTitleOrDescription(String title, String description);
//    Product findByPriceLessThanEqual(double price);
//    Product findByPriceLessThan(double price); // < price
//    Product findByPriceGreaterThanEqual(double price); // >= price
//    Product findByPriceGreaterThan(double price); // > price
//    Product findByPriceBetweenStartPriceAndEndPrice(double startPrice, double endPrice);
    @Query(value = CustomQueries.FIND_PRODUCT_BY_TITLE, nativeQuery = true)
    Product findProductByTitleLike(String title);

    @Query(value = "select * from product", nativeQuery = true)
    List<Product> findAllProducts();
}
