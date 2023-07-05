package com.aca.rystransportes.controllers;

import com.aca.rystransportes.models.entities.EmployeeFreight;
import com.aca.rystransportes.services.impls.EmployeeFreightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empfreight")
public class EmployeeFreightController {
    @Autowired
    EmployeeFreightServiceImpl userService;

    @GetMapping()
    public List<EmployeeFreight> showEmployeeFreight() {
        return userService.getAllEmployeeFreight();
    }

    @GetMapping("/{id}")
    public EmployeeFreight getEmployeeFreight(@PathVariable Integer id) {
        return userService.getEmployeeFreightById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public EmployeeFreight createEmployeeFreight(@RequestBody EmployeeFreight user) {
        return userService.createEmployeeFreight(user);
    }

    @PutMapping()
    public EmployeeFreight updateEmployeeFreight(@RequestBody EmployeeFreight user) {
        return userService.updateEmployeeFreight(user);
    }

    @DeleteMapping(value = "{id}")
    public @ResponseBody String deleteEmployeeFreight(@PathVariable("id")  Integer id ) {
        userService.deleteEmployeeFreight(id);
        return null;
    }
}
