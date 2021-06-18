package com.example.service;

import com.example.dao.Purchase;
import com.example.dao.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
