package com.aca.rystransportes.repositories;

import com.aca.rystransportes.models.entities.Units;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnitsRepository extends JpaRepository<Units, String> {

}
