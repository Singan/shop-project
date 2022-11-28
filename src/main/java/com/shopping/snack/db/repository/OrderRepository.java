package com.shopping.snack.db.repository;

import com.shopping.snack.db.entity.Orders;
import com.shopping.snack.db.entity.OrdersItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
@Transactional
public class OrderRepository {
    private final EntityManager em;
    public Long orderInsert(Orders orders){
        em.persist(orders);
        for (OrdersItem o: orders.getOrdersItems()) {
            o.setOrders(orders);
        }

        return orders.getOrdersNo();
    }

}
