package com.jpaapp.tp5.Repository;

import com.jpaapp.tp5.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

