package com.dh.clase36.integradora.service;

import com.dh.clase36.integradora.entities.AppUser;
import com.dh.clase36.integradora.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<AppUser> usuarioBuscado= userRepository.findByEmail(email);
        if (usuarioBuscado.isPresent()){
            //devolvemos al usuario buscado
            return usuarioBuscado.get();
        }
        else{
            throw new UsernameNotFoundException("El email ingresando no es correcto");
        }
    }
}
