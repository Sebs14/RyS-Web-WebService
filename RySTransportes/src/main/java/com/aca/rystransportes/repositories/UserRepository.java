package com.aca.rystransportes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aca.rystransportes.models.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByEmail(String email);
}
