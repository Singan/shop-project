package com.shopping.snack.db.service;

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
    public Member findMember(Member member){
        return memberRepository.findMember(member);
    }
}
