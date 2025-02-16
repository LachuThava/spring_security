package com.service.auth.Repository;

import com.service.auth.Entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

     Role findByRoleName(com.service.auth.Enum.Role name);

     List<Role> findAll();


}
