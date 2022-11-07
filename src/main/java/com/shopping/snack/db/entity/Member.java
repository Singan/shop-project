package com.shopping.snack.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @Column(name = "member_no")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberNo;

    @Column(name = "member_id")
    private String memberId;
    @Column(name = "member_password")
    private String memberPassword;
    @Column(name = "member_birth")
    private LocalDate memberBirth;
    @Column(name = "member_gender")
    private String memberGender;
    @Column(name = "member_address")
    private String memberAddress;
    @Column(name = "member_email")
    private String memberEmail;
    @Column(name = "member_phone")
    private String memberPhone;
    @Column(name = "member_name")
    private String memberName;
    @Column(name = "member_roles")
    private String memberRoles;

}
