package com.practice.EcomProductService.repository;

import com.practice.EcomProductService.model.Category;
import com.practice.EcomProductService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
