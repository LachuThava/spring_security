package com.service.auth.Dto.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.servlet.http.HttpServletResponse;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse {

    private Object data;
    private String message;
    private MetaData meta;




}

