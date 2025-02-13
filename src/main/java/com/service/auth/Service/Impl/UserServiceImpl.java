package com.service.auth.Service.Impl;

import com.service.auth.Dto.UserDto;
import com.service.auth.Entity.Role;
import com.service.auth.Entity.User;
import com.service.auth.Repository.RoleRepository;
import com.service.auth.Repository.UserRepository;
import com.service.auth.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    @Override
    public User createUser(UserDto userDto) {
        return convertDtoToUser(userDto);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    private User convertDtoToUser(UserDto userDto) {

        Role role = roleRepository.findByRoleName(com.service.auth.Enum.Role.ROLE_USER.name());

        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());
        user.setGender(userDto.getGender());
        user.setRole(List.of(role));
        user.setAge(userDto.getAge());
        user.setAddress(userDto.getAddress());

        return userRepository.save(user);

    }

}
