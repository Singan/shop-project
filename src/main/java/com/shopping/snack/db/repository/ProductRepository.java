package com.shopping.snack.db.repository;

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
public class ProductRepository {
    private final EntityManager em;

    @Transactional
    public Long productInsert(Product product){
        em.persist(product);
        return product.getProductNo();
    }


    public List<Product> productList(){

        return em.createQuery("select p from Product p").getResultList();
    }

    public List<Product> productList(String category){

        return em.createQuery("select p from Product p where p.productCate = :category")
                .setParameter("category",category)
                .getResultList();
    }
    public Product productFind(Long no){
        return em.find(Product.class , no);
    }
}
