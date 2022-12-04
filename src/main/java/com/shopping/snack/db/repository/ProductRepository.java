package com.shopping.snack.db.repository;

import com.shopping.snack.DTO.ProductInsertDTO;
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
    public void productUpdate(ProductInsertDTO productInsertDTO){
        Product product = em.find(Product.class,productInsertDTO.getProductNo());
        product.setProductCount(productInsertDTO.getCount());
        product.setProductName(productInsertDTO.getName());
        product.setProductDetail(productInsertDTO.getName());
        product.setProductCate(productInsertDTO.getCategory());
        product.setProductDiscount(productInsertDTO.getDiscountRate());
        product.setProductPrice(productInsertDTO.getPrice());
        product.setProductShort(productInsertDTO.getShortContent());
        product.setProductThumbnail(productInsertDTO.getProductThumbnail());
    }

    @Transactional
    public Reply replyInsert(Reply reply){
        em.persist(reply);
        return reply;
    }
    @Transactional
    public List<Product> productList(){


        return em.createQuery("select p from Product p where p.productView = true").setFirstResult(0).setMaxResults(8).getResultList();
    }

    public List<Product> productList(String category){

        return em.createQuery("select p from Product p where p.productCate = :category and p.productView = true")
                .setParameter("category",category)
                .getResultList();
    }
    public List<Product> productList(String category,Integer count){

        return em.createQuery("select p from Product p where p.productCate = :category and p.productView = true")
                        .setFirstResult(count*8).setMaxResults((count+1)*8)
                .setParameter("category",category)
                .getResultList();
    }
    public Product productFind(Long no){
        return em.createQuery("select p from Product p  where p.productNo = :no and p.productView = true",Product.class)
                .setParameter("no",no).getSingleResult();
    }
    public List<Product> productFind(List<Long> no){

        return em.createQuery("select p from Product p where p.productNo in (:no) and p.productView = true").
                setParameter("no",no).getResultList();
    }
    public List<Product> productPopularList(Integer pageNo){

        return em.createQuery("select p from Product p where p.productDiscount >0 and p.productView = true order by p.productDiscount desc").
                setFirstResult(pageNo*8).setMaxResults((pageNo+1)*8).getResultList();
    }
    public List<Product> productSalesList(Integer pageNo){

        return em.createQuery("select p from Product p where p.productDiscount >0 and p.productView = true order by p.productDiscount desc").
                setFirstResult(pageNo*8).setMaxResults((pageNo+1)*8).getResultList();
    }
    @Transactional
    public void productDelete(Long no) {
        em.createQuery("update Product p set p.productView = false where p.productNo = :no").setParameter("no",no).executeUpdate();
    }

    public List<Reply> myReplyList(Member member){
        return em.createQuery("select r from Reply r where r.replyWriter = :member")
                .setParameter("member",member).getResultList();
    }
}
