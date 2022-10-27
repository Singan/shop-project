package com.shopping.snack.db.repository;

import com.shopping.snack.db.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberRepository {
    private final EntityManager em;

    @Transactional
    public Long join(Member member){
        em.persist(member);
        return member.getMemberNo();
    }
}
