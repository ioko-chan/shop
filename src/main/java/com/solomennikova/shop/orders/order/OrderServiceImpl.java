package com.solomennikova.shop.orders.order;

import com.solomennikova.shop.convert.Convert;
import com.solomennikova.shop.exception.OrderNotFoundException;
import com.solomennikova.shop.goods.CakeRepository;
import com.solomennikova.shop.orders.order.enumsfororder.OrderStatus;
import com.solomennikova.shop.orders.purchase.PurchaseEntity;
import com.solomennikova.shop.rest.dto.Order;
import com.solomennikova.shop.rest.dto.User;
import com.solomennikova.shop.users.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    private final CakeRepository cakeRepository;
    private final UserRepository userRepository;
    private final Convert converter;

    public OrderServiceImpl(OrderRepository orderRepository, CakeRepository cakeRepository,
                            UserRepository userRepository, Convert converter) {
        this.orderRepository = orderRepository;
        this.cakeRepository = cakeRepository;
        this.userRepository = userRepository;
        this.converter = converter;
    }

    @Override
    public void createOrder(Order order) {
        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setPayment(order.getPayment());
        orderEntity.setOrderStatus(order.getOrderStatus());
        orderEntity.setPurchases(order.getPurchases().stream()
                .map(purchase -> {
                    PurchaseEntity purchaseEntity = new PurchaseEntity();
                    purchaseEntity.setOrder(orderEntity);
                    purchaseEntity.setCake(cakeRepository.findById(purchase.getCake().getId()).orElseThrow(RuntimeException::new));
                    purchaseEntity.setNumber(purchase.getNumber());
                    return purchaseEntity;
                }).collect(Collectors.toList()));
        orderEntity.setUser(userRepository.findByNumber(order.getUser().getNumber()));
        orderRepository.save(orderEntity);
    }

    @Override
    public List<Order> getOrderList(User user) {
        return orderRepository.findByUserId(user.getId()).stream()
                .map(converter::orderEntityToOrder).collect(Collectors.toList());
    }

    @Override
    public Order getOrder(Long id) {
        OrderEntity orderEntity = orderRepository.findById(id).orElseThrow(RuntimeException::new);
        return converter.orderEntityToOrder(orderEntity);
    }

    @Override
    public List<Order> getOrderList() {
        List<OrderEntity> orderEntityList = orderRepository.findAll();
        return orderEntityList.stream()
                .map(converter::orderEntityToOrder).collect(Collectors.toList());
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);

    }

    @Override
    public void changeStatus(Long id, OrderStatus orderStatus) {
        OrderEntity orderEntity = orderRepository.findById(id).orElseThrow(() ->
                new OrderNotFoundException("Order doesn't exist"));
        orderEntity.setOrderStatus(orderStatus);
        orderRepository.save(orderEntity);
    }

}
