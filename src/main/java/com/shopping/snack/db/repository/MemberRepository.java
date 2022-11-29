 package com.shopping.snack.db.repository;

import com.shopping.snack.db.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

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
    @Transactional
    public Member findMember(String id){
            List<Member> memberList = em.createQuery("select m from Member m where m.memberId = :id ",Member.class).setParameter(
                "id",id).getResultList();
            if(memberList.isEmpty()) {
                System.out.println(id);
                System.out.println(memberList.size());
                System.out.println("없는 아이디");
                return null;
            }
            return memberList.get(0);
    }

     @Transactional
     public String findMemberId(String name,String phone){
         String str;
        try {
             str = em.createQuery("select m.memberName from Member m " +
                             "where m.memberName = :name and m.memberPhone = :phone ",String.class)
                     .setParameter("name",name).
                     setParameter("phone",phone).getSingleResult();
        }catch (Exception e){
            str="아이디를 찾을 수 없습니다.";
        }
         return str;
     }
}
