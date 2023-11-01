package com.shopping.snack.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @Column(name  ="member_zone_code")
    private Integer memberZoneCode;


    @Column(name  ="member_detail_address")
    private String memberDetailAddress;
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
    @Column(name = "member_image"  ,columnDefinition = "LONGTEXT")
    private String memberImage;

    @OneToMany(mappedBy = "member" ,fetch =FetchType.LAZY)
    @JsonIgnore
    private List<Basket> basketList = new ArrayList<>();
}
