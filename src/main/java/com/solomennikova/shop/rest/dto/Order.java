package com.solomennikova.shop.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solomennikova.shop.orders.order.enumsfororder.Delivery;
import com.solomennikova.shop.orders.order.enumsfororder.OrderStatus;
import com.solomennikova.shop.orders.order.enumsfororder.Payment;
import com.solomennikova.shop.orders.purchase.PurchaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Schema
@Validated
public class Order {
    @NotNull
    @Schema(description = "ID", required = false)
    @JsonProperty("id")
    private Long id;

    @NotNull
    @Schema(description = "user", required = false)
    @JsonProperty("user")
    private User user;

    @NotNull
    @Schema(description = "purchases", required = false)
    @JsonProperty("purchases")
    private List<Purchase> purchases;

    @NotNull
    @Schema(description = "delivery", required = false)
    @JsonProperty("delivery")
    private Delivery delivery;

    @NotNull
    @Schema(description = "orderStatus", required = false)
    @JsonProperty("orderStatus")
    private OrderStatus orderStatus;

    @NotNull
    @Schema(description = "payment", required = false)
    @JsonProperty("payment")
    private Payment payment;

    @NotNull
    @Schema(description = "deliveryAddress", required = false)
    @JsonProperty("deliveryAddress")
    private String deliveryAddress;

    @NotNull
    @Schema(description = "deliveryTimeLike", required = false)
    @JsonProperty("deliveryTimeLike")
    private LocalDateTime deliveryTimeLike;

}
