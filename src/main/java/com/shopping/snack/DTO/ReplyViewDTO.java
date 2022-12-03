package com.shopping.snack.DTO;

import com.shopping.snack.db.entity.Member;
import com.shopping.snack.db.entity.Product;
import com.shopping.snack.db.entity.Reply;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
public class ReplyViewDTO {


    private String replyWriter;
    private String replyProduct;
    private LocalDate replyDay;
    private String replyImage;
    private String replyContent;

    public ReplyViewDTO(Reply reply){
        replyDay=reply.getReplyDay();
        replyWriter=reply.getReplyWriter().getMemberName();
        replyProduct=reply.getReplyProduct().getProductName();
        replyImage=reply.getReplyImage();
        replyContent=reply.getReplyContent();
    };
}
