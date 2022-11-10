package com.shopping.snack.db.repository;

import com.shopping.snack.db.entity.Member;
import com.shopping.snack.db.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductRepository {
    private final EntityManager em;

    @Transactional
    public Long productInsert(Product product){
        em.persist(product);
        return product.getProductNo();
    }
}