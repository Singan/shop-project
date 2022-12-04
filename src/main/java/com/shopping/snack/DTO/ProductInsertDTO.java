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
    private Long productNo;
    private String productThumbnail;
    private String image;
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
        product.setProductThumbnail(image);
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
