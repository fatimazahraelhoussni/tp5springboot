package com.jpaapp.tp5.Repository;

import com.jpaapp.tp5.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

