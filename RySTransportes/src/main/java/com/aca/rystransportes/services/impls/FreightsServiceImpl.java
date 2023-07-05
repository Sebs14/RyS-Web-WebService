package com.aca.rystransportes.services.impls;

import com.aca.rystransportes.models.dtos.FreightsDTO;
import com.aca.rystransportes.models.entities.Clients;
import com.aca.rystransportes.models.entities.Freights;
import com.aca.rystransportes.models.entities.Units;
import com.aca.rystransportes.repositories.FreightsRepository;
import com.aca.rystransportes.services.ClientsService;
import com.aca.rystransportes.services.FreightsService;
import com.aca.rystransportes.services.UnitsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FreightsServiceImpl implements FreightsService {

    @Autowired
    FreightsRepository freightsRepository;
    
    @Autowired
	private ClientsService clientService;
    
    @Autowired
	private UnitsService unitService;

    @Override
    public Freights getFreightsById(Integer id) {
        return freightsRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Freight not found by id :" + id));
    }

    @Override
    public List<Freights> getAllFreights() {
        return freightsRepository.findAll();
    }

    @Override
    public void createFreights(FreightsDTO freights) throws Exception {
    	
    	Freights freight = new Freights();
    	
    	Clients client = clientService.getClientsById(freights.getClients());
    	Units unit = unitService.getUnitsById(freights.getUnits());
    	System.out.println(client.getIdClient());
    	
    	freight.setIdFreight(freights.getIdFreight());
    	freight.setUnits(unit);
    	freight.setDate(freights.getDate());
    	freight.setClients(client);
    	freight.setDestination(freights.getDestination());
    	freight.setTonage(freights.getTonage());
    	freight.setType(freights.getType());
    	freight.setShipment(freights.getShipment());
    	freight.setComments(freights.getComments());
    	
    	
         freightsRepository.save(freight);
    }

    @Override
    public void updateFreights(FreightsDTO freights) {
       freightsRepository.findById(freights.getIdFreight())
       								.orElseThrow( () -> 
       								new ResponseStatusException(HttpStatus.NOT_FOUND, "Freight not found by id :" + freights.getIdFreight()));
       Freights freight = getFreightsById(freights.getIdFreight());
   	
	   	Clients client = clientService.getClientsById(freights.getClients());
	   	Units unit = unitService.getUnitsById(freights.getUnits());
	   	
	   	freight.setUnits(unit);
	   	freight.setDate(freights.getDate());
	   	freight.setClients(client);
	   	freight.setDestination(freights.getDestination());
	   	freight.setTonage(freights.getTonage());
	   	freight.setType(freights.getType());
	   	freight.setShipment(freights.getShipment());
	   	freight.setComments(freights.getComments()); 
	   	
       freightsRepository.save(freight);
    }

    @Override
    public void deleteFreights(Integer id) {
        freightsRepository.deleteById(id);
    }
}
