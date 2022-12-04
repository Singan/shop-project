package com.shopping.snack.db.service;

import com.shopping.snack.DTO.ProductInsertDTO;
import com.shopping.snack.DTO.ReplyInsertDTO;
import com.shopping.snack.DTO.SessionMemberDTO;
import com.shopping.snack.db.entity.Product;
import com.shopping.snack.db.entity.Reply;
import com.shopping.snack.db.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Long productInsert(ProductInsertDTO productInsertDTO){
        return productRepository.productInsert(productInsertDTO.getProduct());
    }

    public Long productInsert(ProductInsertDTO productInsertDTO,String thumbnail){
        Product product=productInsertDTO.getProduct();
        product.setProductThumbnail(thumbnail);
        return productRepository.productInsert(product);
    }
    public List<Product> productList(){

        return productRepository.productList();
    }
    public List<Product> productList(String category){

        return productRepository.productList(category);
    }
    public List<Product> productList(String category,Integer count){

        return productRepository.productList(category,count);
    }
    public Product productFind(Long no){
        return productRepository.productFind(no);
    }
    public List<Product> productFind(Long[] no){
        List<Long> noList = Arrays.asList(no);
        return productRepository.productFind(noList);
    }

    public List<Product> productPopularList(Integer pageNo){
        if(pageNo==null)
            pageNo=0;
        return productRepository.productPopularList(pageNo);
    }
    public List<Product> productSaleList(Integer pageNo){
        if(pageNo==null)
            pageNo=0;
        return productRepository.productSalesList(pageNo);
    }

    public Reply replyInsert(ReplyInsertDTO replyInsertDTO, SessionMemberDTO memberDTO){
        Reply reply = replyInsertDTO.getReply();
        reply.setReplyWriter(memberDTO.createMember());
        return productRepository.replyInsert(reply);
    }
    public void productDelete(Long no){
        productRepository.productDelete(no);
    }
}
