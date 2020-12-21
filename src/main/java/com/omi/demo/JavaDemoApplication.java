package com.omi.demo;

import com.omi.demo.models.EnumRole;
import com.omi.demo.models.Role;
import com.omi.demo.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class JavaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner init(RoleRepository roleRepository) {

        return args -> {

            Optional<Role> user = roleRepository.findByName(EnumRole.ROLE_USER);
            if (user == null) {
                Role userRole = new Role();
                userRole.setName(EnumRole.ROLE_USER);
                roleRepository.insert(userRole);
                System.out.println("Create User role");
            } else {
                System.out.println("User role existed");
            }

            Optional<Role> mod = roleRepository.findByName(EnumRole.ROLE_MODERATOR);
            if (mod == null) {
                Role userRole = new Role();
                userRole.setName(EnumRole.ROLE_MODERATOR);
                roleRepository.insert(userRole);
                System.out.println("Create Mod role");
            } else {
                System.out.println("Mod role existed");
            }

            Optional<Role> admin = roleRepository.findByName(EnumRole.ROLE_ADMIN);
            if (admin == null) {
                Role userRole = new Role();
                userRole.setName(EnumRole.ROLE_ADMIN);
                roleRepository.insert(userRole);
                System.out.println("Create Admin role");
            } else {
                System.out.println("Admin role existed");
            }

        };

    }
}
