package com.aca.rystransportes.services.impls;

import com.aca.rystransportes.models.entities.Freights;
import com.aca.rystransportes.repositories.FreightsRepository;
import com.aca.rystransportes.services.FreightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FreightsServiceImpl implements FreightsService {

    @Autowired
    FreightsRepository freightsRepository;

    @Override
    public Freights getFreightsById(Integer id) {
        return freightsRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Freight not found by id :" + id));
    }

    @Override
    public List<Freights> getAllFreights() {
        return freightsRepository.findAll();
    }

    @Override
    public Freights createFreights(Freights freights) {
        return freightsRepository.save(freights);
    }

    @Override
    public Freights updateFreights(Freights freights) {
       freightsRepository.findById(freights.getIdFreight()).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Freight not found by id :" + freights.getIdFreight()));
       return freightsRepository.save(freights);
    }

    @Override
    public void deleteFreights(Integer id) {
        freightsRepository.deleteById(id);
    }
}
