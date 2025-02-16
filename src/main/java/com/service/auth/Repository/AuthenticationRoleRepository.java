package com.service.auth.Repository;

import com.service.auth.Entity.AuthenticationRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRoleRepository extends JpaRepository<AuthenticationRole,Long> {
}
