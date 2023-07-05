package com.aca.rystransportes.controllers;

import com.aca.rystransportes.services.UserService;
import com.aca.rystransportes.services.impls.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.aca.rystransportes.models.entities.User;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping()
    public List<User> showUser() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String dui) {
        return userService.getUserById(dui);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping()
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping(value = "{id}")
    public @ResponseBody String deleteUser(@PathVariable("id")  String dui ) {
        userService.deleteUser(dui);
        return null;
    }
}
