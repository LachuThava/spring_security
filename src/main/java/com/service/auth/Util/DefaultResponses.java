package com.service.auth.Util;

import com.service.auth.Dto.Response.CommonResponse;
import com.service.auth.Dto.Response.LoginResponse;
import com.service.auth.Dto.Response.MetaData;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;


public class DefaultResponses {

    public static CommonResponse loginSuccess(LoginResponse loginResponse) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setData(loginResponse);
        commonResponse.setMessage("Login successfully.");
        commonResponse.setMeta(new MetaData(HttpServletResponse.SC_OK,"Login Success",false));
        return commonResponse;
    }

    public static CommonResponse loginFailed() {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setData(null);
        commonResponse.setMessage("Login failed, please try again.");
        commonResponse.setMeta(new MetaData(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"Login Failed",true));
        return commonResponse;
    }

    public static CommonResponse userNotFound() {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setData(null);
        commonResponse.setMessage("User not found.");
        commonResponse.setMeta(new MetaData(HttpServletResponse.SC_NOT_FOUND,"User not found.",true));
        return commonResponse;
    }

}
