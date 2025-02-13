package com.service.auth.Dto;

import com.service.auth.Enum.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String address;
    private Gender gender;
    private Integer age;


}
