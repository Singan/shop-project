package com.shopping.snack.db.repository;

import com.shopping.snack.db.entity.Member;
import com.shopping.snack.db.entity.Product;
import com.shopping.snack.db.entity.Reply;
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
    @Transactional
    public Reply replyInsert(Reply reply){
        em.persist(reply);
        return reply;
    }

    public List<Product> productList(){

        return em.createQuery("select p from Product p").setFirstResult(0).setMaxResults(8).getResultList();
    }

    public List<Product> productList(String category){

        return em.createQuery("select p from Product p where p.productCate = :category")
                .setParameter("category",category)
                .getResultList();
    }
    public Product productFind(Long no){
        return em.createQuery("select p from Product p join fetch p.replyList where p.productNo = :no",Product.class)
                .setParameter("no",no).getSingleResult();
    }
    public List<Product> productFind(List<Long> no){

        return em.createQuery("select p from Product p where p.productNo in (:no)").
                setParameter("no",no).getResultList();
    }
    public List<Product> productPopularList(Integer pageNo){

        return em.createQuery("select p from Product p where p.productDiscount >0 order by p.productDiscount desc").
                setFirstResult(pageNo*8).setMaxResults((pageNo+1)*8).getResultList();
    }
    public List<Product> productSalesList(Integer pageNo){

        return em.createQuery("select p from Product p where p.productDiscount >0 order by p.productDiscount desc").
                setFirstResult(pageNo*8).setMaxResults((pageNo+1)*8).getResultList();
    }
}
