package com.aca.rystransportes.services;

import com.aca.rystransportes.models.dtos.UserInfo;
import com.aca.rystransportes.models.entities.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUser();

    void register(UserInfo userInfo) throws Exception;
    List<User> findAll() throws Exception;
    User findOneByEmail(String email) throws Exception;

    Boolean comparePassword(User user, String passToCompare) throws Exception;
    void insertToken(User user, String token) throws Exception;
    Boolean isTokenValid(User user, String token) throws Exception;
    User getUserAuthenticated() throws Exception;
}
