package com.aca.rystransportes.controllers;

import com.aca.rystransportes.models.entities.Freights;
import com.aca.rystransportes.services.impls.FreightsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/freights")
public class FreightsController {
    @Autowired
    FreightsServiceImpl freightsService;

    @GetMapping()
    public List<Freights> showFreights(){
        return freightsService.getAllFreights();
    }

    @GetMapping("/id")
    public Freights getFreights(@PathVariable Integer id){
        return freightsService.getFreightsById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Freights createdFreights(@RequestBody Freights freights) {
        return freightsService.createFreights(freights);
    }

    @PutMapping()
    public Freights updateFreights(@RequestBody Freights freights){
        return freightsService.updateFreights(freights);
    }

    @DeleteMapping(value = {"/id"})
    public @ResponseBody String deleteFreights(@PathVariable("id") Integer id){
        freightsService.deleteFreights(id);
        return null;
    }
}
