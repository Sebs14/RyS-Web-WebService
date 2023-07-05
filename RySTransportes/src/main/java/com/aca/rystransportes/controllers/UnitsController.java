package com.aca.rystransportes.controllers;

import com.aca.rystransportes.models.entities.Units;
import com.aca.rystransportes.services.UnitsService;
import com.aca.rystransportes.services.impls.ClientsServiceImpl;
import com.aca.rystransportes.services.impls.UnitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/units")
public class UnitsController {
    @Autowired
    UnitServiceImpl unitService;

    @GetMapping
    public List<Units> showUnits() {
        return unitService.getAllUnits();
    }

    @GetMapping("/id")
    public Units getUnits(@PathVariable String plate){
        return unitService.getUnitsById(plate);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Units createUnits(@PathVariable Units units){
        return unitService.CreateUnits(units);
    }

    @PutMapping()
    public Units updateUnits(@PathVariable Units units){
        return unitService.UpdateUnits(units);
    }

    @DeleteMapping(value = "/{id}")
    public @ResponseBody String deleteUnits(@PathVariable("id") String plate){
        unitService.DeleteUnits(plate);
        return null;
    }
}
