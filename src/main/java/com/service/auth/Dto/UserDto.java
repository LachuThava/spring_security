package com.service.auth.Dto;


import com.service.auth.Enum.Gender;
import com.service.auth.Enum.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private List<Role> role;
    private String password;
    private String address;
    private Gender gender;
    private Integer age;


}
