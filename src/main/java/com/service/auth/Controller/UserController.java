package com.service.auth.Controller;

import com.service.auth.Dto.UserDto;
import com.service.auth.Entity.User;
import com.service.auth.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("${user.api.header}")
public class UserController {

    private final UserService userService;

    @PostMapping("${user.api.method.create-user}")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok().body(userService.createUser(userDto));
    }

    @GetMapping("${user.api.method.get-all}")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

}
