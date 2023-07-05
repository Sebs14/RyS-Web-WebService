package com.aca.rystransportes.controllers;

import com.aca.rystransportes.models.entities.Clients;
import com.aca.rystransportes.services.impls.ClientsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientsController{
    @Autowired
    ClientsServiceImpl clientsService;

    @GetMapping()
    public List<Clients> showClients() {
        return clientsService.getAllClients();
    }

    @GetMapping("/{id}")
    public Clients getClients(@PathVariable Integer id) {
        return clientsService.getClientsById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Clients createClients(@RequestBody Clients clients) {
        return clientsService.createClients(clients);
    }

    @PutMapping()
    public Clients updateClients(@RequestBody Clients clients) {
        return clientsService.updateClients(clients);
    }

    @DeleteMapping(value = "{id}")
    public @ResponseBody String deleteClients(@PathVariable("id")  Integer id ) {
        clientsService.deleteClients(id);
        return null;
    }
}
