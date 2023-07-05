package com.aca.rystransportes.services;

import com.aca.rystransportes.models.entities.Clients;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientsService {
    public List<Clients> getAllClients();

    public Clients getClientsById(Integer dui);

    public Clients createClients(Clients clients);
    public void deleteClients(Integer dui);

    public Clients updateClients(Clients clients);
}
