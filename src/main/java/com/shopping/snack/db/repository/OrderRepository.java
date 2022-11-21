package com.shopping.snack.db.repository;

import com.shopping.snack.db.entity.Orders;
import com.shopping.snack.db.entity.OrdersItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class OrderRepository {
    private final EntityManager em;
    public void orderInsert(Orders orders){
        em.persist(orders);

    }

}
