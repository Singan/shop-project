package com.shopping.snack.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;

@Getter
@Setter
public class LoginDTO implements Serializable {
    private String id;
    private String pwd;
}
