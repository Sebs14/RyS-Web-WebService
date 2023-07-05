package com.aca.rystransportes.services.impls;

import com.aca.rystransportes.models.dtos.UserInfo;
import com.aca.rystransportes.models.entities.Token;
import com.aca.rystransportes.models.entities.User;
import com.aca.rystransportes.repositories.TokenRepository;
import com.aca.rystransportes.repositories.UserRepository;
import com.aca.rystransportes.services.UserService;
import com.aca.rystransportes.utils.TokenManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private TokenManager tokenManager;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void register(UserInfo userInfo) throws Exception {
        User user = new User();

        String encryptedPassword = passEncoder.encode(userInfo.getPassword());

        user.setEmail(userInfo.getEmail());
        user.setPassword(encryptedPassword);
        user.setName(userInfo.getName());

        userRepository.save(user);

    }

    @Override
    public List<User> findAll() throws Exception {
        return userRepository.findAll();
    }

    @Override
    public User findOneByEmail(String email) throws Exception {
        User foundUser = userRepository
                .findOneByEmail(email);

        return foundUser;
    }

    @Override
    public Boolean comparePassword(User user, String passToCompare) throws Exception {
        return passEncoder.matches(passToCompare, user.getPassword());
    }

    @Override
    public void insertToken(User user, String token) throws Exception {
        cleanTokens(user);

        Token newToken = new Token(token, user);
        tokenRepository.save(newToken);

    }

    @Override
    public Boolean isTokenValid(User user, String token) throws Exception {
        cleanTokens(user);

        List<Token> tokens = tokenRepository.findByUserAndActive(user, true);

        return tokens.stream()
                .filter((userToken) -> {
                    return userToken.getContent().equals(token) && userToken.getActive();
                })
                .findAny()
                .orElse(null) != null;
    }

    @Override
    public User getUserAuthenticated() throws Exception {
        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return userRepository.findOneByEmail(email);
    }

    @Transactional(rollbackOn = Exception.class)
    private void cleanTokens(User user) {
        List<Token> tokens = tokenRepository.findByUserAndActive(user, true);

        tokens.forEach((userToken) -> {
            if(!tokenManager.validateJwtToken(userToken.getContent(), user.getEmail())) {
                userToken.setActive(false);
                tokenRepository.save(userToken);
            }
        });
    }
}
