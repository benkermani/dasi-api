package fr.insalyon.dasi.dao;

import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.modele.Consultation;
import fr.insalyon.dasi.metier.modele.Employe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author DASI Team
 */
public class ConsultationDao {

    public void creer(Consultation consultation) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.persist(consultation);
    }

    public Consultation chercherParId(Long employeId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(Consultation.class, employeId); // renvoie null si l'identifiant n'existe pas
    }

    public Consultation chercherConsultationEnCours(Employe employe) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Consultation> query = em.createQuery("SELECT c FROM "
                + "Consultation c WHERE c.employe = :employe AND c.finie = FALSE ", Consultation.class);
        query.setParameter("employe", employe);
        List<Consultation> employes = query.getResultList();
        Consultation result = null;
        if (!employes.isEmpty()) {
            result = employes.get(0); // premier de la liste
        }
        return result;
    }

    public List<Consultation> chercherParClient(Client client) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Consultation> query = em.createQuery("SELECT c FROM Consultation c WHERE c.client = :client", Consultation.class);
        query.setParameter("client", client);
        List<Consultation> employes = query.getResultList();
        return employes;
    }

    public List<Consultation> listerConsultations() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Consultation> query = em.createQuery("SELECT c FROM Consultation c ORDER BY c.nom ASC", Consultation.class);
        return query.getResultList();
    }
      
    public void sauvegarderConsultation(Consultation c){
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.merge(c);
    }
    // modifier / supprimer  ... 
}
