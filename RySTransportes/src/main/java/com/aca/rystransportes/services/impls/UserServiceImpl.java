package com.aca.rystransportes.services.impls;

import com.aca.rystransportes.models.entities.User;
import com.aca.rystransportes.repositories.UserRepository;
import com.aca.rystransportes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(String dui) {
        return userRepo.findById(dui).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found with id :" + dui ));
    }

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public void deleteUser(String dui) {
        userRepo.deleteById(dui);
    }

    @Override
    public User updateUser(User user) {
        userRepo.findById(user.getDui()).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found with id : "+user.getDui()) );
        return userRepo.save(user);
    }
}
