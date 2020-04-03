/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;

import java.io.Serializable;
import java.security.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *
 * @author Benjamin
 */
@Entity
public class Consultation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp horaire;
    private boolean finie;
    private String commentaire;
    private String numeroTelephone;
    @ManyToOne
    private Employe employe;
    @ManyToOne
    private Client client;
    
    
    protected Consultation() {
    }

    public Consultation(Timestamp horaire, boolean finie, String commentaire, String numeroTelephone, Employe employe, Client client) {
        this.horaire = horaire;
        this.finie = finie;
        this.commentaire = commentaire;
        this.numeroTelephone = numeroTelephone;
        this.employe = employe;
        this.client = client;
    }

    public Timestamp getHoraire() {
        return horaire;
    }

    public void setHoraire(Timestamp horaire) {
        this.horaire = horaire;
    }

    public boolean isFinie() {
        return finie;
    }

    public void setFinie(boolean finie) {
        this.finie = finie;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }
    
    public String toString(){
        return "CONSULTATION - horaire :" + horaire + ", finie :" + finie +
                ", commentaire :" + commentaire + ", numeroTelephone :" +
                numeroTelephone;
    }
}
