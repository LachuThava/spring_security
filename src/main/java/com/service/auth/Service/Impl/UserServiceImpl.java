package com.service.auth.Service.Impl;

import com.service.auth.Dto.UserDto;
import com.service.auth.Entity.AuthenticationRole;
import com.service.auth.Entity.Role;
import com.service.auth.Entity.User;
import com.service.auth.Repository.AuthenticationRoleRepository;
import com.service.auth.Repository.RoleRepository;
import com.service.auth.Repository.UserRepository;
import com.service.auth.Service.UserService;
import com.service.auth.Util.EncoderCommon;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AuthenticationRoleRepository authenticationRoleRepository;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public UserDto createUser(UserDto userDto) {
        User user = convertDtoToUser(userDto);
        return UserDto
                .builder()
                .id(user.getId())
                .age(user.getAge())
                .email(user.getEmail())
                .role(user.getAuthenticationRoles()
                        .stream()
                        .filter(authenticationRole -> authenticationRole.getRole() != null)
                        .map(authenticationRole -> authenticationRole.getRole().getRoleName())
                        .toList())
                .address(user.getAddress())
                .gender(user.getGender())
                .password(user.getPassword())
                .name(user.getName())
                .build();
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtos = new ArrayList<>();
         userRepository.findAll()
                .forEach(user -> {
                    List<com.service.auth.Enum.Role> roles = user.getAuthenticationRoles()
                            .stream()
                            .filter(authenticationRole -> authenticationRole.getRole() != null)
                            .map(authenticationRole -> authenticationRole.getRole().getRoleName())
                            .toList();
                    log.info("LOG :: getAuthenticationRoles : {}",user.getAuthenticationRoles());
                    UserDto build = UserDto
                            .builder()
                            .id(user.getId())
                            .age(user.getAge())
                            .email(user.getEmail())
                            .address(user.getAddress())
                            .gender(user.getGender())
                            .role(roles)
                            .password(user.getPassword())
                            .name(user.getName())
                            .build();
                    userDtos.add(build);
                });
        return userDtos;
    }


    private User convertDtoToUser(UserDto userDto) {

        Role role = roleRepository.findByRoleName(com.service.auth.Enum.Role.ROLE_USER);
        log.info("LOG :: role : {}", role);

        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(EncoderCommon.encodePasswordStrength5(userDto.getPassword()));
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        user.setGender(userDto.getGender());
        user.setAddress(userDto.getAddress());


        User savedUser =  userRepository.save(user);

        log.info("LOG :: savedUser : {}", savedUser);


        AuthenticationRole authenticationRole = AuthenticationRole
                .builder()
                .createdAt(Instant.now().getEpochSecond())
                .role(role)
                .user(savedUser)
                .build();

        AuthenticationRole saveAuthRole = authenticationRoleRepository.save(authenticationRole);
        log.info("LOG :: saveAuthRole : {}", saveAuthRole);
        savedUser.setAuthenticationRoles(Set.of(saveAuthRole));

        return savedUser;
    }

}
