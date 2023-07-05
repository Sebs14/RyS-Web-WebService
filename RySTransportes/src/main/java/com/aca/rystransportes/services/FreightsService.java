package com.aca.rystransportes.services;

import com.aca.rystransportes.models.entities.Freights;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FreightsService {
    public Freights getFreightsById(Integer id);

    public List<Freights> getAllFreights();

    public Freights createFreights(Freights freights);

    public Freights updateFreights(Freights freights);

    public void deleteFreights(Integer id);

}
