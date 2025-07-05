package com.practice.EcomProductService.model;

import com.practice.EcomProductService.dto.Rating;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Product extends BaseModel {
    private String title;
    private String description;
    private String image;
//    private Rating rating;
    @OneToOne
    private Price price;
    @ManyToOne
    private Category category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

//    public Rating getRating() {
//        return rating;
//    }

//    public void setRating(Rating rating) {
//        this.rating = rating;
//    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
