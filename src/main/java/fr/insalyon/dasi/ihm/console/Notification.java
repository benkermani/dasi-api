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
public class Notification {
    String destinataire, telephone, message;

    public Notification() {
    }

    public Notification(String destinataire) {
        this.destinataire = destinataire;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String toString(){
        return "Pour : " + destinataire + ", Tel : " + telephone +
                "\nMessage : " + message;
    }
    
    public void envoyer(){
        System.out.println(this.toString());
    }
}
