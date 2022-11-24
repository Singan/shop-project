package com.shopping.snack.DTO;

import com.shopping.snack.db.entity.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ProductInsertDTO {
    private String name;
    private String content;
    private Long count;
    private String category;
    private Long discountRate;
    private Long price;
    private String shortContent;
    public Product getProduct(){
        Product product = new Product();
        product.setProductCount(this.count);
        product.setProductName(this.name);
        product.setProductDetail(this.content);
        product.setProductCate(this.category);
        product.setProductDiscount(this.discountRate);
        product.setProductPrice(this.price);
        product.setProductShort(this.shortContent);
        return product;
    }
}
