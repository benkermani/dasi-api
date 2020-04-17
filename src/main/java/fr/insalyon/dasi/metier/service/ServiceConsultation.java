/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.service;

import fr.insalyon.dasi.api.AstroAPI;
import fr.insalyon.dasi.api.Prediction;
import fr.insalyon.dasi.dao.ConsultationDao;
import fr.insalyon.dasi.dao.EmployeDao;
import fr.insalyon.dasi.dao.JpaUtil;
import fr.insalyon.dasi.dao.MediumDao;
import fr.insalyon.dasi.ihm.console.Notification;
import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.modele.Consultation;
import fr.insalyon.dasi.metier.modele.Employe;
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.modele.ProfilAstral;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Benjamin
 */
public class ServiceConsultation {

    public List<Medium> listerMediums() {
        MediumDao mediumDao = new MediumDao();
        List<Medium> resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            resultat = mediumDao.listerMediums();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service listerClients()", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }

    public List<Consultation> listeConsultationsClient(Client client){
        ConsultationDao cdao = new ConsultationDao();
        List<Consultation> resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            resultat = cdao.chercherParClient(client);
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service listerClients()", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
       
    
    public Consultation consultationEnCours(Employe e){
        ConsultationDao cdao = new ConsultationDao();
        JpaUtil.creerContextePersistance();
        Consultation resultat = null;
        try {
            resultat = cdao.chercherConsultationEnCours(e);
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service listerClients()", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    
    public void finConsultation(Consultation consultation, String commentaire){
        ConsultationDao cdao = new ConsultationDao();        
        consultation.setCommentaire(commentaire);
        consultation.setFinie(true);
        JpaUtil.creerContextePersistance();
        try {
            cdao.sauvegarderConsultation(consultation);
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service listerClients()", ex);
            
        } finally {
            JpaUtil.fermerContextePersistance();
        }
    }
    
    public boolean demandeConsultation(Client c, Medium m){
        EmployeDao edao = new EmployeDao();
        Employe eLibre = edao.employeLibre(m);
        if(eLibre != null){
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.MINUTE,10);
            Consultation consultation = new Consultation(cal, false ,"", eLibre.getNumeroTelephone(), eLibre, c);
            /*Persister l'objet */
            ConsultationDao cdao = new ConsultationDao();
            cdao.creer(consultation);
            Notification notifClient = new Notification();
            notifClient.setDestinataire(c.getPrenom() + " " + c.getNom());
            notifClient.setTelephone(c.getNumeroTelephone());
            notifClient.setMessage("Bonjour " + c.getPrenom() + ". J’ai bien reçu "
                    + "votre demande de consultation du " + consultation.getHoraire()
                    + ". Vous pouvez dès à présent me contacter au " + consultation.getNumeroTelephone()
                    + ". A tout de suite ! Médiumiquement vôtre, " + m.getDenomination());
            notifClient.envoyer();
            
            Notification notifEmploye = new Notification();
            notifEmploye.setDestinataire(eLibre.getNom());
            notifEmploye.setTelephone(eLibre.getNumeroTelephone());
            notifEmploye.setMessage("Bonjour " + notifEmploye.getDestinataire() + ". Consultation requise pour " + notifClient.getDestinataire() + ". Médium à incarner : " + m.getDenomination());
            notifEmploye.envoyer();
            return true;
        }else{
          return false;
        }
        
        
    }
    
    public Prediction obtenirPrediction(ProfilAstral pa, int amour, int sante, int travail){
        try {
            return new Prediction((new AstroAPI()).getPredictions(pa.getCouleur(), pa.getAnimalTotem(), amour, sante, travail));
        } catch (IOException ex) {
            Logger.getLogger(ServiceConsultation.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
