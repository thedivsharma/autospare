package com.autospare.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.autospare.model.Role;
import com.autospare.model.User;
import com.autospare.repository.UserRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(UserRepository repo, PasswordEncoder encoder) {
        return args -> {

            if (repo.findByUsername("admin").isEmpty()) {
                repo.save(new User("admin", encoder.encode("admin123"), Role.ADMIN));
            }

            if (repo.findByUsername("seller").isEmpty()) {
                repo.save(new User("seller", encoder.encode("seller123"), Role.SELLER));
            }

            if (repo.findByUsername("customer").isEmpty()) {
                repo.save(new User("customer", encoder.encode("cust123"), Role.CUSTOMER));
            }
        };
    }
}