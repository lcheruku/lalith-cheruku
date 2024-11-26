package com.receiptprocessor.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.receiptprocessor.demo.model.Receipt;
import com.receiptprocessor.demo.service.ServiceReceipt;

@RestController // using RestController class for building REST web service
@RequestMapping("/receipts")
public class ReceiptController {

	@Autowired
	private ServiceReceipt serviceReceipt;
	
	// API endpoint for Process Receipts
	@PostMapping("/process")
	public ResponseEntity<Map<String, String>> processReceipt(@RequestBody Receipt receipt) {
		String id = serviceReceipt.processReceipt(receipt);
		return ResponseEntity.ok(Map.of("id", id));
	}
	
	// API endpoint for Get Points
	@GetMapping("/{id}/points")
	public ResponseEntity<Map<String, Integer>> getPoints(@PathVariable String id) {
		int points = serviceReceipt.getPoints(id);
		return ResponseEntity.ok(Map.of("points", points));
	}
	
}
