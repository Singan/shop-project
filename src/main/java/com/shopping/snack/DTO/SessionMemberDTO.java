package com.shopping.snack.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shopping.snack.db.entity.Basket;
import com.shopping.snack.db.entity.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class SessionMemberDTO {
    private Long memberNo;
    private String memberId;
    private String memberPassword;
    private LocalDate memberBirth;
    private String memberGender;
    private String memberAddress;
    private String memberEmail;
    private String memberPhone;
    private String memberName;
    private String memberRoles;
    private String memberDetailAddress;
    private Integer memberZoneCode;
    private String memberImage;
    private List<BasketDTO> basketList = new ArrayList<>();
    public SessionMemberDTO(Member member){
        this.memberNo = member.getMemberNo();
        this.memberId = member.getMemberId();
        this.memberPassword = member.getMemberPassword();
        this.memberBirth = member.getMemberBirth();
        this.memberGender = member.getMemberGender();
        this.memberAddress = member.getMemberAddress();
        this.memberPhone = member.getMemberPhone();
        this.memberEmail = member.getMemberEmail();
        this.memberName = member.getMemberName();
        this.memberImage = member.getMemberImage();
        this.memberRoles = member.getMemberRoles();
        this.memberZoneCode = member.getMemberZoneCode();
        this.memberDetailAddress = member.getMemberDetailAddress();
        this.basketList =member.getBasketList().stream().map(basket -> {
            return new BasketDTO(basket);
        }).collect(Collectors.toList());
    }
    public Member createMember(){
        Member member = new Member();
        member.setMemberNo(this.memberNo);



        return member;
    }
}
