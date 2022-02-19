package com.solomennikova.shop.orders.order;

import com.solomennikova.shop.orders.order.enumsfororder.OrderStatus;
import com.solomennikova.shop.rest.dto.Order;
import com.solomennikova.shop.rest.dto.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    void createOrder(Order order);
    List<Order> getOrderList(User user);
    Order getOrder(Long id);
    List<Order> getOrderList();
    void deleteOrder(Long id);
    void changeStatus(Long id, OrderStatus orderStatus);
}
