package com.solomennikova.shop.goods;

import com.solomennikova.shop.rest.dto.Cake;
import com.solomennikova.shop.rest.dto.Cakes;

public interface CakeService {

    Cakes getCakes();
    Cake getCakeById(Long id);
    void createCake(Cake newCake);
    void updateCake(Cake oldCake, Cake updateCake);
    void deleteCakeById(Long id);
}
