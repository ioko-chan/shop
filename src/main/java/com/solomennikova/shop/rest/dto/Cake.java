package com.solomennikova.shop.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;

@Data
@Schema(description = "Данные о тортике")
@Validated
public class Cake {

    @Null
    @Schema(description = "ID", required = false)
    @JsonProperty("id")
    private Long id;

    @NotNull
    @Schema(description = "Название", required = true)
    @JsonProperty("name")
    private String name;

    @NotNull
    @Schema(description = "Каллорийность", required = true)
    @JsonProperty("calories")
    private BigDecimal calories;

    @NotNull
    @Schema(description = "Цена", required = true)
    @JsonProperty("price")
    private BigDecimal price;

    @NotNull
    @Schema(description = "Вес", required = true)
    @JsonProperty("weight")
    private BigDecimal weight;

    @NotNull
    @Schema(description = "Изображение", required = true)
    @JsonProperty("image")
    private String image;

}
