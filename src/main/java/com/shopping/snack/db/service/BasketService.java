package com.shopping.snack.db.service;

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
    public void basketAppend(Member member, Long no){
        Basket basket = new Basket();
        basket.setMember(member);
        basket.setProduct(productService.productFind(no));
        member.getBasketList().add(basket);
        basketRepository.basketAppend(basket);
    }
}
