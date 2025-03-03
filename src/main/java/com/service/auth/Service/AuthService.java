package com.service.auth.Service;

import com.service.auth.Dto.Request.LoginDto;
import com.service.auth.Dto.Response.CommonResponse;
import com.service.auth.Dto.Response.LoginResponse;
import com.service.auth.Exception.ValidationException;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    CommonResponse login(LoginDto loginDto) throws ValidationException;

}
