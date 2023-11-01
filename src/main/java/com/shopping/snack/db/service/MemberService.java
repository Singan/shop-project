package com.shopping.snack.db.service;

import com.shopping.snack.DTO.LoginDTO;
import com.shopping.snack.DTO.ProfileUpdateDTO;
import com.shopping.snack.db.entity.Member;
import com.shopping.snack.db.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Long join(Member member){
        memberRepository.join(member);
        return member.getMemberNo();
    }
    public Member findMember(LoginDTO loginDTO){

        return memberRepository.findMember(loginDTO.getId());
    }

    public Boolean findMember(String id){
        Boolean flag = false;
        if(memberRepository.findMember(id) == null){
            flag=true;
        }
        return flag;
    }

    public String findMemberId(String name){
      String str = memberRepository.findMemberId(name);

      return str;

    };

    public Member updateMember(ProfileUpdateDTO updateDTO){
        return memberRepository.updateMember(updateDTO);
    }
}
