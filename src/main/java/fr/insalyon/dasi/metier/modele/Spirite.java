/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;

import javax.persistence.Entity;

/**
 *
 * @author Benjamin
 */
@Entity
public class Spirite extends Medium {
    private String support;

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
