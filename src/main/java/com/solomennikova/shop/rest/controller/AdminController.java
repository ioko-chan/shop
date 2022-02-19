package com.solomennikova.shop.rest.controller;

import com.solomennikova.shop.goods.CakeService;
import com.solomennikova.shop.orders.order.OrderService;
import com.solomennikova.shop.rest.dto.Cake;
import com.solomennikova.shop.rest.dto.Order;
import com.solomennikova.shop.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping(value = "/adminka")
public class AdminController {

    private final CakeService cakeService;
    private final OrderService orderService;
    private final UserService userService;

    @Autowired
    public AdminController(CakeService cakeService, OrderService orderService, UserService userService){
        this.cakeService = cakeService;
        this.orderService = orderService;
        this.userService = userService;
    }

    @PostMapping(path = "cakes", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cake> createCake(@RequestBody @Valid Cake newCake){
        cakeService.createCake(newCake);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("/menu")
    public ModelAndView getMenu() {
        return new ModelAndView("menu");
    }

    @GetMapping("/orders")
    public ModelAndView getOrders() {
        ModelAndView modelAndView = new ModelAndView("orders");
        modelAndView.addObject("orders", orderService.getOrderList());
        return modelAndView;
    }

    @GetMapping("/cakes")
    public ModelAndView getBeats() {
        ModelAndView modelAndView = new ModelAndView("cakes");
        modelAndView.addObject("cakes", cakeService.getCakes().getCakeList());
        return modelAndView;
    }

    @GetMapping("/users")
    public ModelAndView getUsers() {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", userService.getUsers());
        return modelAndView;
    }

    @GetMapping("/order/{id}")
    public ModelAndView getOrder(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("order");
        Order order = orderService.getOrder(id);
        modelAndView.addObject("order", order);
        return modelAndView;
    }

    @PostMapping("/order/{id}/status") // PatchMapping
    public RedirectView changeOrderStatus(@PathVariable Long id, Order order) {
        System.out.println(order.getOrderStatus());
        orderService.changeStatus(id, order.getOrderStatus());
        return new RedirectView(String.format("/admin/order/%d", id));
    }

    @GetMapping("/order/delete/{id}")
    public RedirectView deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return new RedirectView("/adminka/orders");
    }

    @GetMapping("cake/create")
    public ModelAndView fillNewBeat() {
        ModelAndView modelAndView = new ModelAndView("new-cake");
        modelAndView.addObject("cake", new Cake());
        return modelAndView;
    }

    @GetMapping(value = "cake/{id}")
    public ModelAndView getBeat(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("cake");
        modelAndView.addObject("cake", cakeService.getCakeById(id));
        return modelAndView;
    }

    @GetMapping(value = "/cake/delete/{id}")
    public RedirectView deleteBeat(@PathVariable Long id){
        cakeService.deleteCakeById(id);
        return new RedirectView("/adminka/cakes");
    }

    @PostMapping(value = "/cake/create")
    public RedirectView createBeat(Cake cake){
        cakeService.createCake(cake);
        return new RedirectView("/adminka/cake");
    }
}
