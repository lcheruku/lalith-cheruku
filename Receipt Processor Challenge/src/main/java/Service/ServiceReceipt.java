package com.receiptprocessor.demo.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.receiptprocessor.demo.model.Receipt;

@Service
// Service class for processing receipts and getting points for that id 
public class ServiceReceipt {
    private final Map<String, Receipt> receipts = new HashMap<>(); // using HashMap for caching purposes
    private final PointsAwarded pointsAwarded = new PointsAwarded();

    // Service method for Process Receipts. Returns a unique id for each receipt
    public String processReceipt(Receipt receipt) {
        String id = UUID.randomUUID().toString(); // using a UUID(universally unique identifier) to generate unique ID values for each receipt
        receipt.setId(id);
        receipts.put(id, receipt);
        return id;
    }

    // Service method for Get Points. Returns the number of points associated with that receipt(identified by ID)
    public int getPoints(String id) {
        Receipt receipt = receipts.get(id);
        if (receipt == null) throw new NullPointerException("Receipt not found");
        return pointsAwarded.awardPoints(receipt);
    }
}
