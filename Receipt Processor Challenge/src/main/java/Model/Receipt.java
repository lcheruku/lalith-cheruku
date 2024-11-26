package com.receiptprocessor.demo.model;

import java.util.*;

import org.springframework.format.annotation.DateTimeFormat;

// Model class Receipt having details like id, retailer name etc.
public class Receipt {
    private String id; // generated randomly using UUID. view service class "ServiceReceipt" for logic
    private String retailer;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String purchaseDate;
    @DateTimeFormat(pattern = "HH:mm")
    private String purchaseTime;
    // Item is another model class having a short description and price. 
    // Using Item class as a property of Receipt class, ensuring Object Composition.
    private List<Item> items; 
    private String total;

    // Getter and Setter methods
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRetailer() {
        return retailer;
    }

    public void setRetailer(String retailer) {
        this.retailer = retailer;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
