package com.shopping.snack.db.repository;

import com.shopping.snack.DTO.ProfileUpdateDTO;
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
    public Long join(Member member) {
        em.persist(member);
        return member.getMemberNo();
    }

    @Transactional
    public Member findMember(String id) {
        List<Member> memberList = em.createQuery("select m from Member m where m.memberId = :id ", Member.class).setParameter(
                "id", id).getResultList();
        if (memberList.isEmpty()) {
            System.out.println(id);
            System.out.println(memberList.size());
            System.out.println("없는 아이디");
            return null;
        }
        return memberList.get(0);
    }

    @Transactional
    public String findMemberId(String name) {
        String str;
        try {
            str = em.createQuery("select m.memberName from Member m " +
                            "where m.memberName = :name ", String.class)
                    //.setParameter("phone",phone)
                    .setParameter("name", name).
                    getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException("없는 아이디입니다.");
        }
        return str;
    }

    @Transactional
    public Member updateMember(ProfileUpdateDTO updateDTO) {
        Member m = em.find(Member.class, updateDTO.getNo());
        m.setMemberZoneCode(updateDTO.getZoneCode());
        m.setMemberName(updateDTO.getName());
        m.setMemberDetailAddress(updateDTO.getAddressDetail());
        m.setMemberAddress(updateDTO.getAddress());
        m.setMemberImage(updateDTO.getProfileImage());
        m.setMemberEmail(updateDTO.getEmail());
        return m;
    public Member findMember(Member member){
        return em.createQuery("select m from Member m where m.memberId = :id",Member.class).setParameter(
                "id",member.getMemberId())).getSingleResult();
    }
}
