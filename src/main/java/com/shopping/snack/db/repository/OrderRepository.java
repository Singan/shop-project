package com.shopping.snack.db.repository;

import com.shopping.snack.db.entity.Member;
import com.shopping.snack.db.entity.Orders;
import com.shopping.snack.db.entity.OrdersItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class OrderRepository {
    private final EntityManager em;
    public Long orderInsert(Orders orders){

        for (OrdersItem o: orders.getOrdersItems()) {
            o.setOrders(orders);
        }
        em.persist(orders);
        return orders.getOrdersNo();
    }

    public List<Orders> ordersList(Member member){
        return em.createQuery("select distinct o from Orders o join fetch o.ordersItems where o.ordersMember =:member")
                .setParameter("member",member).getResultList();
    }

    public Orders findOrders(Long no){
        Orders o = null;
        try {
            o =em.createQuery("select o from Orders o where o.ordersNo = :no",Orders.class).setParameter("no",no).getSingleResult();
        }catch (Exception e){

        }
        return o;
    }
    @Transactional
    public void orderDelete(Long no){
        Orders o =findOrders(no);
        em.remove(o);
    }
}
