package com.service.auth.Dto.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {

    private String email;
    private String password;

}
