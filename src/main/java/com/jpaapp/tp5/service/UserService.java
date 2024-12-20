package com.jpaapp.tp5.service;


import com.jpaapp.tp5.Repository.RoleRepository;
import com.jpaapp.tp5.Repository.UserRepository;
import com.jpaapp.tp5.entity.Role;
import com.jpaapp.tp5.entity.User;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public Optional<User> findUserByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }

    public Optional<Role> findRoleByName(String name) {
        return Optional.ofNullable(roleRepository.findByName(name));
    }
}

