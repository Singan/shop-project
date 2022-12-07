package com.shopping.snack.DTO;

import com.shopping.snack.db.entity.Orders;
import com.shopping.snack.db.entity.Product;
import com.shopping.snack.db.enumClass.OrdersStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class OrderViewDTO {
    private Long productNo;
    private String productThumbnail;
    private String productName;
    private String productDetail;
    private Integer productCount;
    private Long productPrice;
    private String productShort;
    private Long productDiscount;
    private Long orderNo;
    private List<OrdersItemDTO> ordersItems;
    private OrdersStatus ordersStatus;
    private LocalDate ordersDate;
    private Long ordersPrice;
    private String ordersDetailAddress;
    private String ordersAddress;
    private Integer ordersZoneCode;
    public OrderViewDTO(Product product){
        productNo = product.getProductNo();
        productThumbnail = product.getProductThumbnail();
        productName = product.getProductName();
        productDetail = product.getProductDetail();
        productPrice = product.getProductPrice();
        productShort = product.getProductShort();
        productDiscount = product.getProductDiscount();
        productCount = 1;
    }
    public OrderViewDTO(Product product,Integer count){
        this(product);
        this.productCount = count;
    }
    public OrderViewDTO(Orders orders){
        this.orderNo = orders.getOrdersNo();
        this.ordersStatus = orders.getOrdersStatus();
        this.ordersDate = orders.getOrdersDate();
        this.ordersDetailAddress = orders.getOrdersDetailAddress();
        this.ordersAddress = orders.getOrdersAddress();
        this.ordersPrice = orders.getOrdersPrice();
        ordersZoneCode = orders.getOrdersZoneCode();
        ordersItems = orders.getOrdersItems().stream().map(ordersItem -> new OrdersItemDTO(ordersItem)).collect(Collectors.toList());
    }
}
