package com.solomennikova.shop.rest.controller;

import com.solomennikova.shop.goods.CakeService;
import com.solomennikova.shop.goods.CakeServiceImpl;
import com.solomennikova.shop.rest.dto.Cake;
import com.solomennikova.shop.rest.dto.Cakes;
import com.solomennikova.shop.exception.CakeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@Validated
@RequestMapping("cakes")
public class CakeController {

    private final CakeService cakeService;

    @Autowired
    public CakeController(CakeService cakeService){
        this.cakeService = cakeService;
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cakes cakes(){
        return cakeService.getCakes();
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Cake cake(@PathVariable Long id){
        return cakeService.getCakeById(id);

    }



}
