package com.solomennikova.shop.rest.controller.foruser;

import com.solomennikova.shop.exception.UserExistsException;
import com.solomennikova.shop.orders.order.OrderService;
import com.solomennikova.shop.rest.dto.Order;
import com.solomennikova.shop.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;

    @Autowired
    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping(value = "order/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "order/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody @Valid Order order) {
        try {
            userService.createUser(order.getUser());
        } catch (UserExistsException e) {
            e.printStackTrace();
        }
        orderService.createOrder(order);
    }
}
