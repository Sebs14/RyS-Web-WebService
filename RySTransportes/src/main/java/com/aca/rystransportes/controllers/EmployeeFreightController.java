package com.aca.rystransportes.controllers;

import com.aca.rystransportes.models.dtos.EmpFreightInfo;
import com.aca.rystransportes.models.dtos.MessageDTO;
import com.aca.rystransportes.models.entities.EmployeeFreight;
import com.aca.rystransportes.models.entities.User;
import com.aca.rystransportes.services.impls.EmployeeFreightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empfreight")
public class EmployeeFreightController {
    @Autowired
    EmployeeFreightServiceImpl employeeFreightService;

    @GetMapping()
    public List<EmployeeFreight> showEmployeeFreight() {
        return employeeFreightService.getAllEmployeeFreight();
    }

    @GetMapping("/{id}")
    public EmployeeFreight getEmployeeFreight(@PathVariable Integer id) {
        return employeeFreightService.getEmployeeFreightById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public ResponseEntity<MessageDTO> createEmployeeFreight(EmpFreightInfo empFreightInfo, BindingResult result) {
        try {
            if(result.hasErrors()) {
                String errors = result.getAllErrors().toString();


                return new ResponseEntity<>(
                        new MessageDTO("Hay errores: " + errors),
                        HttpStatus.BAD_REQUEST
                );
            }

            employeeFreightService.createEmployeeFreight(empFreightInfo);

            return new ResponseEntity<>(
                    new MessageDTO("Usuario Registrado"),
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
    public EmployeeFreight updateEmployeeFreight(@RequestBody EmployeeFreight user) {
        return employeeFreightService.updateEmployeeFreight(user);
    }

    @DeleteMapping(value = "{id}")
    public @ResponseBody String deleteEmployeeFreight(@PathVariable("id")  Integer id ) {
        employeeFreightService.deleteEmployeeFreight(id);
        return null;
    }
}
