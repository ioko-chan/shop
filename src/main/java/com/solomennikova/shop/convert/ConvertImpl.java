package com.solomennikova.shop.convert;

import com.solomennikova.shop.goods.CakeEntity;
import com.solomennikova.shop.orders.order.OrderEntity;
import com.solomennikova.shop.orders.purchase.PurchaseEntity;
import com.solomennikova.shop.rest.dto.Cake;
import com.solomennikova.shop.rest.dto.Order;
import com.solomennikova.shop.rest.dto.Purchase;
import com.solomennikova.shop.rest.dto.User;
import com.solomennikova.shop.users.UserEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ConvertImpl implements Convert{
    @Override
    public Cake cakeEntityToCake(CakeEntity cakeEntity) {
        Cake cake=new Cake();
        cake.setId(cakeEntity.getId());
        cake.setName(cakeEntity.getName());
        cake.setWeight(cakeEntity.getWeight());
        cake.setCalories(cakeEntity.getCalories());
        cake.setImage(cakeEntity.getImage());
        cake.setPrice(cakeEntity.getPrice());
        return cake;
    }
    public CakeEntity cakeToCakeEntity(Cake cake){
        CakeEntity cakeEntity=new CakeEntity();
        cakeEntity.setId(cake.getId());
        cakeEntity.setName(cake.getName());
        cakeEntity.setWeight(cake.getWeight());
        cakeEntity.setCalories(cake.getCalories());
        cakeEntity.setImage(cake.getImage());
        cakeEntity.setPrice(cake.getPrice());
        return cakeEntity;
    }

    @Override
    public UserEntity userToUserEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setNumber(user.getNumber());
        userEntity.setName(user.getName());
        return userEntity;
    }

    @Override
    public User userEntityToUser(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setNumber(userEntity.getNumber());
        user.setName(userEntity.getName());
        return user;
    }

    @Override
    public Purchase purchaseEntityToPurchase(PurchaseEntity purchaseEntity) {
        Purchase purchase = new Purchase();
        purchase.setCake(cakeEntityToCake(purchaseEntity.getCake()));
        purchase.setNumber(purchaseEntity.getNumber());
        return purchase;
    }

    @Override
    public Order orderEntityToOrder(OrderEntity orderEntity) {
        Order order= new Order();
        order.setId(orderEntity.getId());
        order.setUser(userEntityToUser(orderEntity.getUser()));
        order.setPayment(orderEntity.getPayment());
        order.setOrderStatus(orderEntity.getOrderStatus());
        order.setDeliveryAddress(orderEntity.getDeliveryAddress());
        order.setDelivery(orderEntity.getDelivery());
        order.setDeliveryTimeLike(orderEntity.getDeliveryTimeLike());
        order.setPurchases(orderEntity.getPurchases().stream()
                .map(this::purchaseEntityToPurchase)
                .collect(Collectors.toList()));
        return order;

    }
    private PurchaseEntity purchaseToPurchaseEntity(Purchase purchase) {
        PurchaseEntity purchaseEntity = new PurchaseEntity();
        purchaseEntity.setNumber(purchase.getNumber());
        return purchaseEntity;
    }
    @Override
    public OrderEntity orderToOrderEntity(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUser(userToUserEntity(order.getUser()));
        orderEntity.setPayment(order.getPayment());
        orderEntity.setOrderStatus(order.getOrderStatus());
        orderEntity.setPurchases(order.getPurchases().stream()
                .map(this::purchaseToPurchaseEntity).collect(Collectors.toList()));
        orderEntity.setDeliveryAddress(order.getDeliveryAddress());
        orderEntity.setDelivery(order.getDelivery());
        orderEntity.setDeliveryTimeLike(order.getDeliveryTimeLike());
        return orderEntity;
    }
}
