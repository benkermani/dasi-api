/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.api;

public class Prediction {
    private String amour, sante, travail;

    public Prediction() {
    }

    public Prediction(String amour, String sante, String travail) {
        this.amour = amour;
        this.sante = sante;
        this.travail = travail;
    }
    
    public String getAmour() {
        return amour;
    }

    public String getSante() {
        return sante;
    }

    public String getTravail() {
        return travail;
    }
    
    
    
}
