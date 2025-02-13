package com.service.auth.Util;

import com.service.auth.Entity.Role;
import com.service.auth.Enum.Permission;
import com.service.auth.Repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Role> roles  = roleRepository.findAll();

        if(roles.isEmpty()){
            Role userRole = Role
                    .builder()
                    .permissions(List.of(Permission.PERMISSION_READ, Permission.PERMISSION_WRITE))
                    .roleName(com.service.auth.Enum.Role.ROLE_USER.toString())
                    .build();

            roleRepository.save(userRole);


            Role adminRole = Role
                    .builder()
                    .permissions(List.of(Permission.PERMISSION_READ,
                            Permission.PERMISSION_WRITE,
                            Permission.PERMISSION_DELETE,
                            Permission.PERMISSION_UPDATE,
                            Permission.PERMISSION_ALL))
                    .roleName(com.service.auth.Enum.Role.ROLE_ADMIN.toString())
                    .build();

            roleRepository.save(adminRole);
        }

    }
}
