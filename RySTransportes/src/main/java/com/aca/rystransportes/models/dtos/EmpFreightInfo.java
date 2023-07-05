package com.aca.rystransportes.models.dtos;

import com.aca.rystransportes.models.entities.Freights;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class EmpFreightInfo {

    @NotBlank
    private Freights freight;

    @NotBlank
    private String position;

    @NotBlank
    private float payment;

    @NotBlank
    private float viatic;

    @NotBlank
    private float extraPayment;

    @NotBlank
    private Date freightdate;

    //Constructors

    public EmpFreightInfo() {
        super();
    }

    public EmpFreightInfo(Freights freight, String position,
                          float payment, float viatic, float extraPayment,
                          Date freightdate) {
        super();
        this.freight = freight;
        this.position = position;
        this.payment = payment;
        this.viatic = viatic;
        this.extraPayment = extraPayment;
        this.freightdate = freightdate;
    }

    //Getters and setters

    public Freights getFreight() {
        return freight;
    }

    public void setFreight(Freights freight) {
        this.freight = freight;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    public float getViatic() {
        return viatic;
    }

    public void setViatic(float viatic) {
        this.viatic = viatic;
    }

    public float getExtraPayment() {
        return extraPayment;
    }

    public void setExtraPayment(float extraPayment) {
        this.extraPayment = extraPayment;
    }

    public Date getFreightdate() {
        return freightdate;
    }

    public void setFreightdate(Date freightdate) {
        this.freightdate = freightdate;
    }
}
