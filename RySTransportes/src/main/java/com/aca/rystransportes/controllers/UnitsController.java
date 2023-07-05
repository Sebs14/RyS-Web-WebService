package com.aca.rystransportes.controllers;

import com.aca.rystransportes.models.dtos.EmpFreightInfo;
import com.aca.rystransportes.models.dtos.MessageDTO;
import com.aca.rystransportes.models.dtos.UnitInfo;
import com.aca.rystransportes.models.entities.Units;
import com.aca.rystransportes.services.UnitsService;
import com.aca.rystransportes.services.impls.ClientsServiceImpl;
import com.aca.rystransportes.services.impls.UnitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/units")
public class UnitsController {
    @Autowired
    UnitServiceImpl unitService;

    @GetMapping()
    public List<Units> showUnits() {
        return unitService.getAllUnits();
    }

    @GetMapping("/id")
    public Units getUnits(@PathVariable String plate){
        return unitService.getUnitsById(plate);
    }

    @PostMapping("/add")
    public ResponseEntity<MessageDTO> createUnits(UnitInfo unitInfo, BindingResult result) {
        try {
            if(result.hasErrors()) {
                String errors = result.getAllErrors().toString();


                return new ResponseEntity<>(
                        new MessageDTO("Hay errores: " + errors),
                        HttpStatus.BAD_REQUEST
                );
            }

            
            unitService.createUnits(unitInfo);

            return new ResponseEntity<>(
                    new MessageDTO("Unidad Registrada"),
                    HttpStatus.CREATED
            );

        } catch (Exception e) {
            return new ResponseEntity<>(
                    new MessageDTO("Error interno"),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
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
