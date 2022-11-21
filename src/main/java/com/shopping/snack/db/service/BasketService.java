package com.shopping.snack.db.service;

import com.shopping.snack.DTO.BasketDTO;
import com.shopping.snack.DTO.SessionMemberDTO;
import com.shopping.snack.db.entity.Basket;
import com.shopping.snack.db.entity.Member;
import com.shopping.snack.db.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepository basketRepository;
    private final ProductService productService;
    public void basketAppend(SessionMemberDTO member, Long no){
        Basket basket = new Basket();
        basket.setMember(member.createMember());
        basket.setBasketCount(1);
        basket.setProduct(productService.productFind(no));
        member.getBasketList().add(new BasketDTO(basket));
        basketRepository.basketAppend(basket);
    }
}
