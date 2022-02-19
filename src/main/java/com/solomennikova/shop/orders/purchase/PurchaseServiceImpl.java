package com.solomennikova.shop.orders.purchase;

import com.solomennikova.shop.convert.Convert;
import com.solomennikova.shop.orders.order.OrderService;

public class PurchaseServiceImpl implements PurchaseService{
    private final OrderService orderService;
    private final Convert converter;

    public PurchaseServiceImpl(OrderService orderService, Convert converter) {
        this.orderService = orderService;
        this.converter = converter;
    }
}
