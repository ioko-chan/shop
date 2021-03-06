package com.solomennikova.shop.goods;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "CAKE")
public class CakeEntity {

    private @Id @GeneratedValue( strategy = GenerationType.IDENTITY ) Long id;

    @Column( name = "name")
    private String name;

    private BigDecimal calories;

    private BigDecimal price;

    private BigDecimal weight;

    private String image;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        CakeEntity that = (CakeEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}