package com.aca.rystransportes.models.dtos;

import jakarta.validation.constraints.NotBlank;

public class UnitInfo {

    @NotBlank
    String plate;

    @NotBlank
    String brand;

    @NotBlank
    String model;

    @NotBlank
    String gpsid;

    //Constructors

    public UnitInfo() {
        super();
    }

    public UnitInfo(String plate, String brand, String model, String gpsid) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.gpsid = gpsid;
    }

    //Getters and setters

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGpsid() {
        return gpsid;
    }

    public void setGpsid(String gpsid) {
        this.gpsid = gpsid;
    }
}
