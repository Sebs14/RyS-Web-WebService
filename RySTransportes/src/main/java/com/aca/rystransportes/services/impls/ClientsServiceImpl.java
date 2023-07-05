package com.aca.rystransportes.services.impls;

import com.aca.rystransportes.models.entities.Clients;
import com.aca.rystransportes.repositories.ClientsRepository;
import com.aca.rystransportes.services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClientsServiceImpl implements ClientsService {
    
    @Autowired
    ClientsRepository clientsRepository;
    
    @Override
    public List<Clients> getAllClients() {
        return clientsRepository.findAll();
    }

    @Override
    public Clients getClientsById(Integer id) {
        return clientsRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found with id :" + id ));
    }

    @Override
    public Clients createClients(Clients clients) {
        return clientsRepository.save(clients);
    }

    @Override
    public void deleteClients(Integer id) {
        clientsRepository.deleteById(id);
    }

    @Override
    public Clients updateClients(Clients clients) {
        clientsRepository.findById(clients.getIdClient()).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found with id : "+clients.getIdClient())) ;
        return clientsRepository.save(clients);
    }
}
