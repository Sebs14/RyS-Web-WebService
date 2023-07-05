package com.aca.rystransportes.models.dtos;

import java.util.Date;

public class FreightsDTO {
	Integer idFreight;

    Integer clients;
    
    String units;

    Date date;

    String client;

    String tonage;

    String destination;

    String type;

    String shipment;

    String comments;

	public FreightsDTO() {
		super();
	}

	public FreightsDTO(Integer idFreight, Integer clients, String units, Date date, String client, String tonage,
			String destination, String type, String shipment, String comments) {
		super();
		this.idFreight = idFreight;
		this.clients = clients;
		this.units = units;
		this.date = date;
		this.client = client;
		this.tonage = tonage;
		this.destination = destination;
		this.type = type;
		this.shipment = shipment;
		this.comments = comments;
	}

	public Integer getIdFreight() {
		return idFreight;
	}

	public void setIdFreight(Integer idFreight) {
		this.idFreight = idFreight;
	}

	public Integer getClients() {
		return clients;
	}

	public void setClients(Integer clients) {
		this.clients = clients;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
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
