package com.shopping.snack.DTO;

import com.shopping.snack.db.entity.Product;
import com.shopping.snack.db.entity.Reply;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ReplyInsertDTO
{
    private String content;
    private Long productNo;
    private MultipartFile image;

    public Reply getReply(){
        Reply reply = new Reply();
        Product product = new Product();
        product.setProductNo(productNo);
        reply.setReplyProduct(product);
        reply.setReplyDay(LocalDate.now());
        reply.setReplyContent(content);

        return reply;
    }

    @Override
    public String toString() {
        return "ReplyInsertDTO{" +
                "content='" + content + '\'' +
                ", productNo=" + productNo +
                ", image='" + image + '\'' +
                '}';
    }
}
