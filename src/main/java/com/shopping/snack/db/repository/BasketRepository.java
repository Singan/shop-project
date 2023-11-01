package com.shopping.snack.db.repository;

import com.shopping.snack.db.entity.Basket;
import com.shopping.snack.db.entity.Member;
import com.shopping.snack.db.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BasketRepository {
    private final EntityManager em;


    @Transactional
    public void basketAppend(Basket basket){
        em.persist(basket);
    }

    public List<Basket> findBasket(Product product, Member member){
      return em.createQuery("select b from Basket b where b.member=:member and b.product=:product",Basket.class)
              .setParameter("member",member)
              .setParameter("product",product)
              .getResultList();
    };
}
