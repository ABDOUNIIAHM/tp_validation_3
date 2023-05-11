package com.example.tp_validation_3;
import com.example.tp_validation_3.entity.Role;
import com.example.tp_validation_3.entity.User;
import com.example.tp_validation_3.repository.RoleRepository;
import com.example.tp_validation_3.service.IntUserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TpValidation3Application implements CommandLineRunner {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    IntUserService userService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    public static void main(String[] args) {
        SpringApplication.run(TpValidation3Application.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {


        userService
                .findById(6)
                .setPassword(bCryptPasswordEncoder.encode("admin"));
        userService
                .findById(7)
                .setPassword(bCryptPasswordEncoder.encode("user"));

    }
}
