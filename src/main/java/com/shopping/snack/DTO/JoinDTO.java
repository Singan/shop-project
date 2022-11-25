package com.shopping.snack.DTO;

import com.shopping.snack.db.entity.Member;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;

@Getter
@Setter
public class JoinDTO {
    private String id;
    private String pwd;
    private LocalDate birth;
    private String gender;
    private String address;
    private String email;
    private String name;
    private String phone;
    private Integer zoneCode;
    private String addressDetail;
    public Member getMember(){
        Member member = new Member();
        member.setMemberId(this.id);
        member.setMemberAddress(this.address);
        member.setMemberGender(this.gender);
        member.setMemberBirth(this.birth);
        member.setMemberEmail(this.email);
        member.setMemberPassword(this.pwd);
        member.setMemberPhone(this.phone);
        member.setMemberName(this.name);
        member.setMemberZoneCode(this.zoneCode);
        member.setMemberDetailAddress(this.addressDetail);
        return member;
    }
}
