package com.aca.rystransportes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aca.rystransportes.models.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {

    User findOneByEmail(String email);
}
