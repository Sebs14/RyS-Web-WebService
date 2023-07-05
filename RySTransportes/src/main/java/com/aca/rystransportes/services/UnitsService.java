package com.aca.rystransportes.services;

import com.aca.rystransportes.models.dtos.UnitInfo;
import com.aca.rystransportes.models.entities.Units;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UnitsService {
    public Units getUnitsById(String plate);

    public List<Units> getAllUnits();

    void createUnits(UnitInfo unitInfo) throws Exception;

    public Units UpdateUnits(Units units);

    public void DeleteUnits(String plate);
}
