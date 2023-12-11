package com.example.UserModule;


import com.example.UserModule.entities.Role;
import com.example.UserModule.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.UserModule.entities.User;
@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private  UserRepository UserRepository;

    @Override
    public void run(String... args) throws Exception {
        if (UserRepository.count() == 0) {
            User user = new User();
            user.setPassword("123");
            user.setEmail("elfadanes@gmail.com");
            user.setRole(Role.valueOf("ADMIN"));
            user.setName("Fad Anes");
            UserRepository.save(user);
        }
    }
}
