package com.aca.rystransportes.services;

import com.aca.rystransportes.models.dtos.FreightsDTO;
import com.aca.rystransportes.models.entities.Freights;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FreightsService {
    public Freights getFreightsById(Integer id);

    public List<Freights> getAllFreights();

    public void createFreights(FreightsDTO freights)  throws Exception;

    public void updateFreights(FreightsDTO freights)  throws Exception;

    public void deleteFreights(Integer id);

}
