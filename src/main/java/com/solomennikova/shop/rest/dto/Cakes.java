package com.solomennikova.shop.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Schema
@Validated
public class Cakes {
    @NotNull
    @Schema(description = "Название", required = true)
    @JsonProperty("cake_list")
    private List<Cake> cakeList;
}
