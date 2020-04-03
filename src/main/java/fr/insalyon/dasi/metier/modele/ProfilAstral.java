/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Id;

/**
 *
 * @author Benjamin
 */
@Embeddable
public class ProfilAstral implements Serializable {
    private String signeChinois;
    private String signeZodiaque;
    private String couleur;
    private String animalTotem;

    protected ProfilAstral() {
    }

    public ProfilAstral(String signeChinois, String signeZodiaque, String couleur, String animalTotem) {
        this.signeChinois = signeChinois;
        this.signeZodiaque = signeZodiaque;
        this.couleur = couleur;
        this.animalTotem = animalTotem;
    }
    
    
    public String getSigneChinois() {
        return signeChinois;
    }

    public void setSigneChinois(String signeChinois) {
        this.signeChinois = signeChinois;
    }

    public String getSigneZodiaque() {
        return signeZodiaque;
    }

    public void setSigneZodiaque(String signeZodiaque) {
        this.signeZodiaque = signeZodiaque;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getAnimalTotem() {
        return animalTotem;
    }

    public void setAnimalTotem(String animalTotem) {
        this.animalTotem = animalTotem;
    }
    
    public String toString(){
        return "signe Chinois :" + signeChinois + ", signe Zodiaque : " + signeZodiaque + ", Couleur :" + couleur + ", animal Totem : " + animalTotem;
    }
    
}
