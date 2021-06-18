package com.example.dao;

import java.util.Set;


import com.example.model.OrderItem;

public class Purchase {

	private Set<OrderItem> orderItems;

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
