package com.aca.rystransportes.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "employeefreight")
public class EmployeeFreight implements Serializable{

    private static final long serialVersionUID =1L;

    @Id
    @Column(name = "idemployeefreight")
    @SequenceGenerator(name = "employeefreight_idemployeefreight_seq", sequenceName = "employeefreight_idemployeefreight_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeefreight_idemployeefreight_seq")
    Integer idEmployeeFreight;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="freight", referencedColumnName = "idfreight", nullable = true)
    Freights freight;

    @Column(name="position")
    String position;

    @Column(name="payment")
    float payment;

    @Column(name="viatic")
    float viatic;

    @Column(name = "extrapayment")
    float extraPayment;

    @Column(name="freight_date")
    Date freightdate;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "dui", nullable = true)
    User user;

    //Constructors


    public EmployeeFreight(Integer idEmployeeFreight, Freights freight,
                           String position, float payment, float viatic,
                           float extraPayment, Date freightdate,
                           User user) {
        super();
        this.idEmployeeFreight = idEmployeeFreight;
        this.freight = freight;
        this.position = position;
        this.payment = payment;
        this.viatic = viatic;
        this.extraPayment = extraPayment;
        this.freightdate = freightdate;
        this.user = user;
    }

    public EmployeeFreight() {
        super();
    }

    //Getters and setters


    public Integer getIdEmployeeFreight() {
        return idEmployeeFreight;
    }

    public void setIdEmployeeFreight(Integer idEmployeeFreight) {
        this.idEmployeeFreight = idEmployeeFreight;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
