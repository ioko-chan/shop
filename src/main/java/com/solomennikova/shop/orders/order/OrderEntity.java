package com.solomennikova.shop.orders.order;

import com.solomennikova.shop.orders.order.enumsfororder.Delivery;
import com.solomennikova.shop.orders.order.enumsfororder.OrderStatus;
import com.solomennikova.shop.orders.order.enumsfororder.Payment;
import com.solomennikova.shop.orders.purchase.PurchaseEntity;
import com.solomennikova.shop.users.UserEntity;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "ORDERS")
public class OrderEntity {
    @Setter(AccessLevel.NONE)
    private @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY ) Long id;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private UserEntity user;

    @ToString.Exclude
    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY,orphanRemoval = true,cascade =CascadeType.ALL )
    private List<PurchaseEntity> purchases;

    @Enumerated(value = EnumType.STRING)
    @JoinColumn(nullable = false)
    private Delivery delivery;

    @Enumerated(value = EnumType.STRING)
    @JoinColumn(nullable = false)
    private OrderStatus orderStatus;

    @Enumerated(value = EnumType.STRING)
    @JoinColumn(nullable = false)
    private Payment payment;

    private String deliveryAddress;

    private LocalDateTime deliveryTimeLike;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderEntity that = (OrderEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
