package com.aca.rystransportes.repositories;

import com.aca.rystransportes.models.entities.Token;
import com.aca.rystransportes.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TokenRepository extends JpaRepository<Token, Long> {
    List<Token> findByUserAndActive(User user, Boolean active);

}
