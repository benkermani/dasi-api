/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.service;

import fr.insalyon.dasi.dao.ConsultationDao;
import fr.insalyon.dasi.dao.EmployeDao;
import fr.insalyon.dasi.dao.MediumDao;
import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.modele.Consultation;
import fr.insalyon.dasi.metier.modele.Employe;
import fr.insalyon.dasi.metier.modele.Medium;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Benjamin
 */
public class ServiceConsultation {

    public List<Medium> listeMediums() {
        MediumDao mdao = new MediumDao();
        return mdao.listerMediums();
    }

    public List<Consultation> listeConsultationsClient(Client client){
        ConsultationDao cdao = new ConsultationDao();
        return cdao.chercherParClient(client);
    }
    
    public Consultation consultationEnCours(Employe e){
        ConsultationDao cdao = new ConsultationDao();
        return cdao.chercherConsultationEnCours(e);
    }
    
    public void finConsultation(Consultation consultation, String commentaire){
        ConsultationDao cdao = new ConsultationDao();        
        consultation.setCommentaire(commentaire);
        consultation.setFinie(true);
        cdao.sauvegarderConsultation(consultation);
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
            return true;
        }else{
          return false;
        }
        
        
    }
}
