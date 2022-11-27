package com.shopping.snack.db.service;

import com.shopping.snack.DTO.BasketDTO;
import com.shopping.snack.DTO.SessionMemberDTO;
import com.shopping.snack.db.entity.Basket;
import com.shopping.snack.db.entity.Member;
import com.shopping.snack.db.entity.Product;
import com.shopping.snack.db.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepository basketRepository;
    private final ProductService productService;
    public void basketAppend(SessionMemberDTO member, Long no){
        Basket basket = new Basket();
        Member realMember = member.createMember();
        basket.setMember(realMember);
        Product product = productService.productFind(no);
        basket.setProduct(product);
        List<BasketDTO> basketDTOList = member.getBasketList();
        List<Basket> basketList = basketRepository.findBasket(product,realMember);
        if(basketList.isEmpty()){
            basket.setBasketCount(1);
            basketRepository.basketAppend(basket);
            basketDTOList.add(new BasketDTO(basket));
        }else{
            basket = basketList.get(0);
            basket.setBasketCount(basket.getBasketCount()+1);
            for (BasketDTO basketDTO:basketDTOList) {
                if(basketDTO.getProductNo() ==no){
                    basketDTO.setProductCount(basketDTO.getProductCount() + 1);
                }
            }
            basketRepository.basketAppend(basket);
        }
    }
}
