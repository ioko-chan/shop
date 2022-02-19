package com.solomennikova.shop.goods;

import com.solomennikova.shop.convert.Convert;
import com.solomennikova.shop.exception.CakeNotFoundException;
import com.solomennikova.shop.rest.dto.Cake;
import com.solomennikova.shop.rest.dto.Cakes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CakeServiceImpl implements CakeService{
    private final CakeRepository cakeRepository;
    private final Convert converter;


    @Autowired
    public CakeServiceImpl(CakeRepository cakeRepository, Convert converter) {
        this.cakeRepository = cakeRepository;
        this.converter = converter;
    }

    @Override
    public Cakes getCakes(){
        List<CakeEntity> cakeEntityList = cakeRepository.findAll();
        List<Cake> cakeList= cakeEntityList.stream().map(c -> {
            Cake cake = new Cake();
            cake.setId(c.getId());
            cake.setCalories(c.getCalories());
            cake.setName(c.getName());
            cake.setPrice(c.getPrice());
            cake.setWeight(c.getWeight());
            cake.setImage(c.getImage());
            return cake;
        }).collect(Collectors.toList());
        Cakes cakes = new Cakes();
        cakes.setCakeList(cakeList);
        return cakes;
    }

    @Override
    public Cake getCakeById(Long id) {
        Optional<CakeEntity> optionalBeat = cakeRepository.findById(id);
        if (optionalBeat.isPresent()) {
            CakeEntity cakeEntity = optionalBeat.get();
            return converter.cakeEntityToCake(cakeEntity);
        }
        else {
            throw new CakeNotFoundException("No such beat exists");
        }
    }

    @Override
    public void createCake(Cake newCake) {
        cakeRepository.save(converter.cakeToCakeEntity(newCake));
    }

    @Override
    public void updateCake(Cake oldCake, Cake updateCake) {
        oldCake.setCalories(updateCake.getCalories());
        oldCake.setName(updateCake.getName());
        oldCake.setPrice(updateCake.getPrice());
        oldCake.setWeight(updateCake.getWeight());
        oldCake.setImage(updateCake.getImage());
    }

    @Override
    public void deleteCakeById(Long id) {
        cakeRepository.deleteById(id);
    }
}
