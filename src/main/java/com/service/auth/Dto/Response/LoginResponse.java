package com.service.auth.Dto.Response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginResponse {


    private String token;
    private String refreshToken;
    private String msg;
    private MetaData metaData;

}
