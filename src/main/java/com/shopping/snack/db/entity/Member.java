package com.shopping.snack.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Member {
    @Id
    @Column
    private String memberNo;

    @Column
    private String memberId;
    @Column
    private String memberPassword;
}
