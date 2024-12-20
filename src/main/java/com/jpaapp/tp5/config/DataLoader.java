package com.jpaapp.tp5.config;

import com.jpaapp.tp5.Repository.RoleRepository;
import com.jpaapp.tp5.Repository.UserRepository;
import com.jpaapp.tp5.entity.Role;
import com.jpaapp.tp5.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public DataLoader(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setName("ROLE_USER");
        roleRepository.save(userRole);

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(new BCryptPasswordEncoder().encode("password"));
        admin.setEmail("admin@example.com");
        admin.setRoles(new HashSet<>(Arrays.asList(adminRole)));
        userRepository.save(admin);

        User user = new User();
        user.setUsername("user");
        user.setPassword(new BCryptPasswordEncoder().encode("password"));
        user.setEmail("user@example.com");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }
}
