package com.aca.rystransportes.services.impls;

import com.aca.rystransportes.models.dtos.UnitInfo;
import com.aca.rystransportes.models.entities.Units;
import com.aca.rystransportes.repositories.UnitsRepository;
import com.aca.rystransportes.services.UnitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UnitServiceImpl implements UnitsService {

    @Autowired
    UnitsRepository unitsRepository;

    @Override
    public Units getUnitsById(String plate) {
        return unitsRepository.findById(plate).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Plate not found by plate :"+ plate));
    }

    @Override
    public List<Units> getAllUnits() {
        return unitsRepository.findAll();
    }

    @Override
    public void createUnits(UnitInfo unitInfo) throws Exception{
        Units units = new Units();

        units.setPlate(unitInfo.getPlate());
        units.setBrand(unitInfo.getBrand());
        units.setModel(unitInfo.getModel());
        units.setGpsid(unitInfo.getGpsid());

        unitsRepository.save(units);
    }

    @Override
    public Units UpdateUnits(Units units) {
        unitsRepository.findById(units.getPlate()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Plate not found by plate :"+ units.getPlate()));
        return unitsRepository.save(units);
    }

    @Override
    public void DeleteUnits(String plate){
        unitsRepository.deleteById(plate);
    }
}
