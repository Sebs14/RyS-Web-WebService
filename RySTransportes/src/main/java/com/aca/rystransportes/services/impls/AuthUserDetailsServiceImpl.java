package com.aca.rystransportes.services.impls;

import com.aca.rystransportes.models.entities.User;
import com.aca.rystransportes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            User userFound = userService.findOneByEmail(email);

            if(userFound != null) {
                return new org.springframework.security.core.userdetails.User(
                        userFound.getEmail(),
                        userFound.getPassword(),
                        new ArrayList<>()
                );
            }else {
                throw new UsernameNotFoundException("Usuario no encontrado: " + email);
            }
        } catch (Exception e) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + email);
        }
    }
}
