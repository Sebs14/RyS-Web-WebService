package com.aca.rystransportes.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.io.Serializable;


@Entity
@Table(name = "clients")
public class Clients implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    @Column(name = "idclient")
    @SequenceGenerator(name = "clients_idclient_seq", sequenceName = "clients_idclient_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clients_idclient_seq")
    Integer idClient;

    @Column(name = "name")
    String name;

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
