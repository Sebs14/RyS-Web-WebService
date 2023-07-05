package com.aca.rystransportes.repositories;

import com.aca.rystransportes.models.entities.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Clients, Integer> {
}
