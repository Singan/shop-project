package com.shopping.snack.DTO;

import com.shopping.snack.db.entity.Member;
import jdk.vm.ci.meta.Local;
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

    private String phone;
    public Member getMember(){
        Member member = new Member();
        member.setMemberId(this.id);
        member.setMemberAddress(this.address);
        member.setMemberGender(this.gender);
        member.setMemberBirth(this.birth);
        member.setMemberEmail(this.email);
        member.setMemberPassword(this.pwd);
        member.setMemberPhone(this.phone);
        return member;
    }
}
