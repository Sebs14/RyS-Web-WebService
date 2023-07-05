package com.aca.rystransportes.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "dui")
    String dui;

    @Column(name = "name")
    String name;

    @Column(name = "password")
    String password;

    @Column(name = "nit")
    String nit;

    @Column(name = "rol")
    String rol;

    @Column(name = "phone")
    String phone;

    @Column(name = "startdate")
    Date startdate;

    @Column(name = "email")
    String email;

    @Column(name = "address")
    String address;

    //Constructors
    public User() {
        super();
    }

    public User(String dui, String name, String password,
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

    // Getters and setters
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
