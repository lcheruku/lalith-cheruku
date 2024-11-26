package com.receiptprocessor.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.regex.Pattern;

import com.receiptprocessor.demo.model.Item;
import com.receiptprocessor.demo.model.Receipt;

// class for writing down Rules
public class PointsAwarded {

/* Rules
 1. One point for every alphanumeric character in the retailer name.
 2. 50 points if the total is a round dollar amount with no cents.
 3. 25 points if the total is a multiple of 0.25.
 4. 5 points for every two items on the receipt.
 5. If the trimmed length of the item description is a multiple of 3, multiply the price by 0.2 and round up to the nearest integer. The result is the number of points earned.
 6. 6 points if the day in the purchase date is odd.
 7. 10 points if the time of purchase is after 2:00pm and before 4:00pm.	
 */
	
	public int awardPoints(Receipt receipt) {
		int points = 0; // points are initialised as 0. If the receipt do not comply any rules. points return 0
		
		/* points calculated based on the rules above */
		
		// One point for every alphanumeric character in the retailer name.
		points += Pattern.compile("[A-Za-z0-9]").matcher(receipt.getRetailer()).results().count();
		
		BigDecimal total = new BigDecimal(receipt.getTotal());
		
		// 50 points if the total is a round dollar amount with no cents.
		if (total.scale() == 0) 
			{
			points += 50;
			}
		
		// 25 points if the total is a multiple of 0.25.
		if (total.remainder(new BigDecimal("0.25")).compareTo(BigDecimal.ZERO) == 0) 
			{
			points += 25;
			}
		
		// 5 points for every two items on the receipt.
		if(receipt.getItems() != null && !receipt.getItems().isEmpty())
		points += (receipt.getItems().size() / 2) * 5;
		
		// If the trimmed length of the item description is a multiple of 3, multiply the price by 0.2 and round up to the nearest integer. The result is the number of points earned.
        if (receipt.getItems() != null) {
            for (Item item : receipt.getItems()) {
                String description = item.getShortDescription();
                if (description != null) {
                    int trimmedLength = description.trim().length();
                    if (trimmedLength % 3 == 0) {
                        BigDecimal price = new BigDecimal(item.getPrice());
                        double result = price.multiply(new BigDecimal("0.2")).doubleValue();

                        // Round up the calculated value to the nearest integer
                        int roundedUp = (int) Math.ceil(result);
                        points += roundedUp;
                    }
                }
            }
        }
		
		// 6 points if the day in the purchase date is odd.
		int day = LocalDate.parse(receipt.getPurchaseDate()).getDayOfMonth();
        if (day % 2 != 0) points += 6;
		
		// 10 points if the time of purchase is after 2:00pm and before 4:00pm.
        LocalTime time = LocalTime.parse(receipt.getPurchaseTime());
        if (time.isAfter(LocalTime.of(14, 0)) && time.isBefore(LocalTime.of(16, 0))) points += 10;
		
		return points;
		
	}

}
