package com.shopping.snack.DTO;

import com.shopping.snack.db.entity.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

public class ProductInsertDTO {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String content;
    @Getter
    @Setter
    private Long count;
    @Getter
    @Setter
    private String category;
    @Getter
    @Setter
    private Long discountRate;
    @Getter
    @Setter
    private Long price;
    @Getter
    @Setter
    private String shortContent;
    @Getter
    @Setter
    private Long productNo;
    @Getter
    @Setter
    private String productThumbnail;
    @Getter
    @Setter
    private MultipartFile image;
    public Product getProduct(){
        Product product = new Product();
        product.setProductCount(this.count);
        product.setProductName(this.name);
        product.setProductDetail(this.content);
        product.setProductCate(this.category);
        product.setProductDiscount(this.discountRate);
        product.setProductPrice(this.price);
        product.setProductShort(this.shortContent);
        product.setProductView(true);
        product.setProductNo(this.productNo);
        return product;
    }
    public ProductInsertDTO(){

    }

    public ProductInsertDTO(Product product){

        setCount(product.getProductCount());
        setName(product.getProductName());
        setContent(product.getProductDetail());
        setCategory(product.getProductCate());
        setDiscountRate(product.getProductDiscount());
        setPrice(product.getProductPrice());
        setShortContent(product.getProductShort());
        productThumbnail = product.getProductThumbnail();
        productNo = product.getProductNo();

    }
}
