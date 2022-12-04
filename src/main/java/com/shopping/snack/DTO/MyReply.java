package com.shopping.snack.DTO;

import com.shopping.snack.db.entity.Reply;
import lombok.Data;

import java.time.LocalDate;
@Data
public class MyReply {
    private LocalDate replyDay;
    private String replyImage;
    private String replyContent;
    private String productName;
    public MyReply(Reply reply){
        replyDay=reply.getReplyDay();
        replyImage=reply.getReplyImage();
        replyContent=reply.getReplyContent();
        productName = reply.getReplyProduct().getProductName();
    };

}
