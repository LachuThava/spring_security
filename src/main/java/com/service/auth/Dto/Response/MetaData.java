package com.service.auth.Dto.Response;

import lombok.*;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class MetaData{

    private int code;
    private String msg;
    private boolean error;

}