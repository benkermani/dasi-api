/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.ihm.console;

/**
 *
 * @author Benjamin
 */
public class Mail {
    private String expediteur, destinataire, sujet, corps;

    public Mail() {
    }
    
    public Mail(String expediteur, String destinataire, String sujet, String corps) {
        this.expediteur = expediteur;
        this.destinataire = destinataire;
        this.sujet = sujet;
        this.corps = corps;
    }

    public String getExpediteur() {
        return expediteur;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public String getSujet() {
        return sujet;
    }

    public String getCorps() {
        return corps;
    }

    public void setExpediteur(String expediteur) {
        this.expediteur = expediteur;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public void setCorps(String corps) {
        this.corps = corps;
    }
    
    public String toString(){
        return "Expéditeur : " + expediteur + "\nPour : " + destinataire +
            "\nSujet : " +  sujet + "\nCorps : " + corps;
    }
    
    public void envoyer(){
        System.out.println(this.toString());
    }
    
}
