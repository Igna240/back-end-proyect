package com.dh.clase36.integradora.service;

import com.dh.clase36.integradora.entities.AppUser;
import com.dh.clase36.integradora.entities.AppUsuarioRoles;
import com.dh.clase36.integradora.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    UserRepository userRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
        String passUser=passwordEncoder.encode("digital");
        userRepository.save(new AppUser("Ignacio","IgnaBre","ib@gmail.com",passUser, AppUsuarioRoles.ROLE_USER));

        String passAdmin=passwordEncoder.encode("digital");
        userRepository.save(new AppUser("Ayelen","AyeSa","ay@gmail.com",passAdmin, AppUsuarioRoles.ROLE_ADMIN));
    }
}
