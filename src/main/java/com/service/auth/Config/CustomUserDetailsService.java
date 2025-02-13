package com.service.auth.Config;

import com.service.auth.Entity.User;
import com.service.auth.Entity.UserPrincipal;
import com.service.auth.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private  UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
         User user = userRepository.findByEmail(s)
                 .orElseThrow(() ->
                new UsernameNotFoundException("User not found with userName : " + s)
        );

         if(user != null){
             UserPrincipal userPrincipal = new UserPrincipal();

             userPrincipal.setEmail(user.getEmail());
             userPrincipal.setPassword(user.getPassword());
             userPrincipal.setName(user.getName());
             return userPrincipal;
         }
        return new UserPrincipal();
    }
}
