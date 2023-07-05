package com.aca.rystransportes.services.impls;

import com.aca.rystransportes.models.entities.EmployeeFreight;
import com.aca.rystransportes.repositories.EmployeeFreightRepository;
import com.aca.rystransportes.services.EmployeeFreightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmployeeFreightServiceImpl implements EmployeeFreightService {

    @Autowired
    EmployeeFreightRepository eFRepository;

    @Override
    public List<EmployeeFreight> getAllEmployeeFreight() {
        return eFRepository.findAll();
    }

    @Override
    public EmployeeFreight getEmployeeFreightById(Integer id) {
        return eFRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Entity not found with id :" + id ));
    }

    @Override
    public EmployeeFreight createEmployeeFreight(EmployeeFreight employeeFreight) {
        return eFRepository.save(employeeFreight);
    }

    @Override
    public void deleteEmployeeFreight(Integer id) {
        eFRepository.deleteById(id);
    }

    @Override
    public EmployeeFreight updateEmployeeFreight(EmployeeFreight employeeFreight) {
        eFRepository.findById(employeeFreight.getIdEmployeeFreight()).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found with id : "+employeeFreight.getIdEmployeeFreight()) );
        return eFRepository.save(employeeFreight);
    }
}
