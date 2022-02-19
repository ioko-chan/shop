package com.solomennikova.shop.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solomennikova.shop.orders.order.OrderEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@Data
@Schema
@Validated
public class User {

    @Null
    @Schema(description = "id")
    @JsonProperty("id")
    Long id;

    @NotNull
    @Schema(description = "name")
    @JsonProperty("name")
    private String name;

    @NotNull
    @Schema(description = "number")
    @JsonProperty("number")
    private String number;
}
