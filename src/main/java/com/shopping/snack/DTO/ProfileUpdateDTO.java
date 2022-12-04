package com.shopping.snack.DTO;

import lombok.Data;

@Data
public class ProfileUpdateDTO {
    private Integer zoneCode;
    private String address;
    private String detailAddress;
    private String email;
    private Long no;
    private String profileImage;
    private String name;
}
