package com.practice.EcomProductService.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class ProductResponseDTO {
    private UUID id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;

    private Rating rating;
    // Getters and Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public Rating getRating() { return rating; }
    public void setRating(Rating rating) { this.rating = rating; }
}

