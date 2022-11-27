package com.shopping.snack.DTO;

import com.shopping.snack.db.entity.Member;
import com.shopping.snack.db.entity.OrdersItem;
import com.shopping.snack.db.enumClass.OrdersStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class OrderDTO {
    private Long ordersNo;
    private List<OrdersItemDTO> ordersItems = new ArrayList<>();
    private String ordersPhone;
    private String ordersDetailAddress;
    private String ordersAddress;
    private Integer ordersZoneCode;
    private String ordersName;
    private LocalDateTime ordersDate;
}
