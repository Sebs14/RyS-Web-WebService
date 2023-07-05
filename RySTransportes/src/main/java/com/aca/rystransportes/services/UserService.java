package com.aca.rystransportes.services;

import com.aca.rystransportes.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.aca.rystransportes.models.entities.User;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public interface UserService {

    public List<User> getAllUser();

    public User getUserById(String dui);

    public User createUser(User user);
    public void deleteUser(String dui);

    public User updateUser(User user);


}
