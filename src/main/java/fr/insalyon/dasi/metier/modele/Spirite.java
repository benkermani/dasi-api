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
 @DiscriminatorValue("SPIRITE")
public class Spirite extends Medium {
    private String support;

    protected Spirite(){
        
    }
    public Spirite(String denomination, String genre, String presentation, String support) {
        this.denomination = denomination;
        this.genre = genre;
        this.presentation = presentation;
        this.support = support;
    }

    
    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }
    
    public String toString(){
        return " SPRITE - denomination :" + denomination + ", genre :" + genre +", presentation :" + presentation + ", support :" + support;
    }
}
