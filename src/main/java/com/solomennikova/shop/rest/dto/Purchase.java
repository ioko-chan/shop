package com.solomennikova.shop.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solomennikova.shop.goods.CakeEntity;
import com.solomennikova.shop.orders.order.OrderEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;


@Data
@Schema
@Validated
public class Purchase {

    @NotNull
    @Schema(description = "cake", required = false)
    @JsonProperty("cake")
    private Cake cake;


    @NotNull
    @Schema(description = "number", required = false)
    @JsonProperty("number")
    private Integer number;
}
