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
@DiscriminatorValue("CARTOMANCIEN")
public class Cartomancien extends Medium {

    public Cartomancien() {
    }
    
    public Cartomancien(String denomination, String genre, String presentation) {
        this.denomination = denomination; 
        this.genre = genre;
        this.presentation = presentation;
    }
    
    public String toString(){
        return "CARTOMANCIEN - denomination :" + denomination + ", genre :" + genre +", presentation :" + presentation;
    }
    
    
    
}
