package com.practice.EcomProductService.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class Rating {
    private double rate;
    private int count;

    public double getRate() { return rate; }
    public void setRate(double rate) { this.rate = rate; }

    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }
}
