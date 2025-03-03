package com.service.auth.Service.Impl;

import com.service.auth.Dto.Request.LoginDto;
import com.service.auth.Dto.Response.CommonResponse;
import com.service.auth.Dto.Response.LoginResponse;
import com.service.auth.Dto.Response.MetaData;
import com.service.auth.Entity.User;
import com.service.auth.Exception.UserNotFoundException;
import com.service.auth.Exception.ValidationException;
import com.service.auth.Repository.UserRepository;
import com.service.auth.Service.AuthService;
import com.service.auth.Service.JwtService;
import com.service.auth.Util.DefaultResponses;
import com.service.auth.Util.EncoderCommon;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

import static com.service.auth.Util.DefaultResponses.*;


@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserDetailsService userDetailsService;

    private final JwtService jwtService;
    private final EncoderCommon encoderCommon;

    @Override
    public CommonResponse login(LoginDto loginDto) throws ValidationException {

        if(!StringUtils.hasText(loginDto.getEmail()) || !StringUtils.hasText(loginDto.getPassword())){
            throw new ValidationException("email or password doesn't have value");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginDto.getEmail());
        if(userDetails  == null){
            return userNotFound();
        }

        if(encoderCommon.matches(loginDto.getPassword(), userDetails.getPassword())){
            LoginResponse loginResponse = LoginResponse
                    .builder()
                    .token(jwtService.generateToken(userDetails, 2))
                    .refreshToken(jwtService.generateToken(userDetails, 3))
                    .build();

            return loginSuccess(loginResponse);
        }else{
            return  loginFailed();
        }



    }
}
