package com.service.auth.Controller;

import com.service.auth.Dto.Request.LoginDto;
import com.service.auth.Dto.Response.CommonResponse;
import com.service.auth.Exception.ValidationException;
import com.service.auth.Service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RequestMapping("${auth.user.header}")
@RestController
public class AuthController {

    private final AuthService authService;


    @PostMapping("${auth.user.method.login}")
    public CommonResponse loginUser(@RequestBody LoginDto loginDto) throws ValidationException {
        return authService.login(loginDto);
    }

}
