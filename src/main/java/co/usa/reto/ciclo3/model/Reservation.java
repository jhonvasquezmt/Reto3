/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.reto.ciclo3.model;

import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author JhonV
 */
@Entity
@Table(name="reservation")
public class Reservation implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    
    date String startDate;
    date String devolutionDate;
    private String status;
    
    @ManyToOne
    @JoinColumn(name="Cabaña")
    @JsonIgnoreProperties("reservations")
    private Cabin cabin;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "Mensajes ")
    @JsonIgnoreProperties("reservations")
    public List<Message> messages;

    @ManyToOne
    @JoinColumn(name="Cliente")
    @JsonIgnoreProperties("reservations")
    private Client client;
    
    @OneToOne(cascade = {CascadeType.PERSIST},mappedBy = "reservation")
    @JsonIgnoreProperties("reservation")
    private Score score;
    
    simpleDateFormat formato = new simpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    starDate = formato.parse(starDate);
    devolutionDate = formato.parse(devolutionDate);

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(String devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Cabin getCabin() {
        return cabin;
    }

    public void setCabin(Cabin cabin) {
        this.cabin = cabin;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
