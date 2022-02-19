package com.solomennikova.shop.convert;

import com.solomennikova.shop.goods.CakeEntity;
import com.solomennikova.shop.orders.order.OrderEntity;
import com.solomennikova.shop.orders.purchase.PurchaseEntity;
import com.solomennikova.shop.rest.dto.Cake;
import com.solomennikova.shop.rest.dto.Order;
import com.solomennikova.shop.rest.dto.Purchase;
import com.solomennikova.shop.rest.dto.User;
import com.solomennikova.shop.users.UserEntity;


public interface Convert {

    Cake cakeEntityToCake(CakeEntity cakeEntity);

    CakeEntity cakeToCakeEntity(Cake cake);

    UserEntity userToUserEntity(User user);

    User userEntityToUser(UserEntity userEntity);

    Purchase purchaseEntityToPurchase(PurchaseEntity purchaseEntity);

    Order orderEntityToOrder(OrderEntity orderEntity);

    OrderEntity orderToOrderEntity(Order order);
}
