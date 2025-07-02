package com.practice.EcomProductService.model;

import com.practice.EcomProductService.dto.Rating;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private int id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;

    private Rating rating;
}
