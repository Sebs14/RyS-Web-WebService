package com.aca.rystransportes.controllers;

import com.aca.rystransportes.models.entities.User;
import com.aca.rystransportes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAllUsers() {

        try {
            User userAuth = userService.getUserAuthenticated();
            System.out.println(userAuth.getName());

            List<User> users = userService.findAll();

            return new ResponseEntity<>(
                    users,
                    HttpStatus.OK
            );

        } catch (Exception e) {
            return new ResponseEntity<>(
                    null,
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
