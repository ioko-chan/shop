package com.solomennikova.shop.goods;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.parser.Entity;

public interface CakeRepository extends JpaRepository<CakeEntity,Long> {
    boolean existsByName(String name);

}
