package com.aca.rystransportes.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "freights")
public class Freights implements Serializable{

    private static final long serialVersionUID =1L;

    @Id
    @Column(name = "idfreight")
    @SequenceGenerator(name = "freights_idfreight_seq", sequenceName = "freights_idfreight_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "freights_idfreight_seq")
    Integer idFreight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client", referencedColumnName = "idclient", nullable = true)
    Clients clients;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="unit", referencedColumnName = "plate", nullable = true)
    Units units;

    @Column(name = "freightdate")
    Date date;

    @Column(name = "tonage")
    String tonage;

    @Column(name = "destination")
    String destination;

    @Column(name = "freighttype")
    String type;

    @Column(name = "shipmentnum")
    String shipment;

    @Column(name = "comments")
    String comments;
    
    public Clients getClients() {
		return clients;
	}

	public void setClients(Clients clients) {
		this.clients = clients;
	}

	public Units getUnits() {
		return units;
	}

	public void setUnits(Units units) {
		this.units = units;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getIdFreight() {
        return idFreight;
    }

    public void setIdFreight(Integer idFreight){

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTonage() {
        return tonage;
    }

    public void setTonage(String tonage) {
        this.tonage = tonage;
    }


    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShipment() {
        return shipment;
    }

    public void setShipment(String shipment) {
        this.shipment = shipment;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
