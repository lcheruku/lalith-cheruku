package com.receiptprocessor.demo.model;

// model class Item having short description and price
public class Item {
    private String shortDescription; // shortDescription is a description of that particular item. It is of variable length.
    private String price;

    // Getters and Setters for shortDescription and price
    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
