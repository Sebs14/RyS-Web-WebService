package com.aca.rystransportes.repositories;

import com.aca.rystransportes.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByEmail(String email);
    User findOneById(Long id);
}
