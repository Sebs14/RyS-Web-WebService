package com.aca.rystransportes.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

public class UserInfo {

    @NotBlank
    private String dui;

    @NotBlank
    private String name;
    @NotBlank
    private String password;

    @NotBlank
    private String nit;

    @NotBlank
    private String rol;

    @NotBlank
    private String phone;


    private Date startdate;

    @NotBlank
    @Pattern(regexp = "^[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+$")
    private String email;

    @NotBlank
    private String address;

    //Constructors

    public UserInfo() {
        super();
    }

    public UserInfo(String dui, String name, String password,
                    String nit, String rol, String phone, Date startdate,
                    String email, String address) {
        super();
        this.dui = dui;
        this.name = name;
        this.password = password;
        this.nit = nit;
        this.rol = rol;
        this.phone = phone;
        this.startdate = startdate;
        this.email = email;
        this.address = address;
    }

    //Getters and setters

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
