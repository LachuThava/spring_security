package com.service.auth.Config;

import com.service.auth.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class TokenValidator {

    private final UserRepository userRepository;

    public boolean isUserAvailable(String email){
        return userRepository.findByEmail(email).isPresent();
    }

}
