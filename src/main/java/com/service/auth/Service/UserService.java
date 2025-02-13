package com.service.auth.Service;

import com.service.auth.Dto.UserDto;
import com.service.auth.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User createUser(UserDto userDto);

    List<User> getAllUsers();
}
