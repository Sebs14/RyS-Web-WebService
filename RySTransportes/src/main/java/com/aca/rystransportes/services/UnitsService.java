package com.aca.rystransportes.services;

import com.aca.rystransportes.models.entities.Units;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UnitsService {
    public Units getUnitsById(String plate);

    public List<Units> getAllUnits();

    public Units CreateUnits(Units units);

    public Units UpdateUnits(Units units);

    public void DeleteUnits(String plate);
}
