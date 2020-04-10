/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Benjamin
 */
@Entity
@DiscriminatorValue("ASTROLOGUE")
public class Astrologue extends Medium {
    private String formation;
    private int promotion;

    public Astrologue() {
    }

    public Astrologue(String denomination, String genre, String presentation, String formation, int promotion) {
        this.denomination = denomination; 
        this.genre = genre;
        this.presentation = presentation;
        this.formation = formation;
        this.promotion = promotion;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }
    
    public String toString(){
        return " ASTROLOGUE - denomination :" + denomination + ", genre :" + genre +
                ", presentation :" + presentation +", formation :" + formation +
                ", promotion :" + promotion;
    }
    
    
}
