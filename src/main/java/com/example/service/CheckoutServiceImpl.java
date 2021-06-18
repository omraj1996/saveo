package com.example.service;

import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.dao.Purchase;
import com.example.dao.PurchaseResponse;

import com.example.model.OrderItem;

@Service
public class CheckoutServiceImpl implements CheckoutService {

	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {

		// generate tracking number
		String orderNumber = generateOrderNumber();

		// populate order with orderItems
		Set<OrderItem> orderItems = purchase.getOrderItems();

		// return a response
		return new PurchaseResponse(orderNumber);
	}

	private String generateOrderNumber() {

		return UUID.randomUUID().toString();
	}
}
