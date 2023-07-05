package com.aca.rystransportes.services;

import com.aca.rystransportes.models.dtos.EmpFreightInfo;
import com.aca.rystransportes.models.entities.EmployeeFreight;
import com.aca.rystransportes.models.entities.EmployeeFreight;
import com.aca.rystransportes.models.entities.Freights;
import com.aca.rystransportes.repositories.EmployeeFreightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public interface EmployeeFreightService {
    public List<EmployeeFreight> getAllEmployeeFreight();
    public EmployeeFreight getEmployeeFreightById(Integer id);

    void createEmployeeFreight(EmpFreightInfo empFreightInfo) throws Exception;
    public void deleteEmployeeFreight(Integer id);

    public EmployeeFreight updateEmployeeFreight(EmployeeFreight employeeFreight);
}
