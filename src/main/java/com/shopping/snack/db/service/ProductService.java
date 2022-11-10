package com.shopping.snack.db.service;

import com.shopping.snack.DTO.ProductInsertDTO;
import com.shopping.snack.db.entity.Product;
import com.shopping.snack.db.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Long productInsert(ProductInsertDTO productInsertDTO){
        return productRepository.productInsert(productInsertDTO.getProduct());
    }
    public List<Product> productList(){

        return productRepository.productList();
    }
}
