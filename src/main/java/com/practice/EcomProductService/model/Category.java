package com.practice.EcomProductService.model;

import jakarta.persistence.Entity;

@Entity
public class Category extends BaseModel{
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
