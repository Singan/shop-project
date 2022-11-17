package com.shopping.snack.db.repository;

import com.shopping.snack.db.entity.Basket;
import com.shopping.snack.db.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BasketRepository {
    private final EntityManager em;

    @Transactional
    public void basketAppend(Basket basket){
        em.persist(basket);
    }
}
