package fr.insalyon.dasi.metier.service;

import fr.insalyon.dasi.api.AstroAPI;
import fr.insalyon.dasi.dao.ClientDao;
import fr.insalyon.dasi.dao.EmployeDao;
import fr.insalyon.dasi.dao.JpaUtil;
import fr.insalyon.dasi.dao.MediumDao;
import fr.insalyon.dasi.metier.modele.Client;
import fr.insalyon.dasi.metier.modele.Medium;
import fr.insalyon.dasi.metier.modele.Spirite;
import fr.insalyon.dasi.metier.modele.Astrologue;
import fr.insalyon.dasi.metier.modele.Cartomancien;
import fr.insalyon.dasi.metier.modele.Employe;
import fr.insalyon.dasi.metier.modele.ProfilAstral;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DASI Team
 */
public class ServiceAuthentification {

    protected ClientDao clientDao = new ClientDao();
    protected EmployeDao employeDao = new EmployeDao();
    protected MediumDao mediumDao = new MediumDao();

    public Long inscrireClient(Client client) {
        Long resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            /* Obtention du profil astral d'un client et affectation de ce 
            profil au client */
            AstroAPI api = new AstroAPI();
            List<String> profil = api.getProfil(client.getPrenom(),client.getDateNaissance());
            ProfilAstral pa = new ProfilAstral(profil.get(1), profil.get(0), profil.get(2), profil.get(3));
            client.setProfilAstral(pa);
            
            clientDao.creer(client);
            
            JpaUtil.validerTransaction();
            resultat = client.getId();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service inscrireClient(client)", ex);
            JpaUtil.annulerTransaction();
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    
    public boolean initialiserEmploye() {
        Long resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            employeDao.creer(new Employe("Arthur","poutreEnbois","0102150405","H"));
            employeDao.creer(new Employe("Sarah","cactus69insa","0102430425","F"));
            employeDao.creer(new Employe("Baptiste","dasi","0202030435","H"));
            employeDao.creer(new Employe("Sylvain","chaussette","0252030425","H"));
            employeDao.creer(new Employe("Elie","bonjour","0102030445","H"));
            JpaUtil.validerTransaction();
            
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service inscrireClient(client)", ex);
            JpaUtil.annulerTransaction();
            return false;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return true;
    }
    
    public boolean initialiserMedium() {
        Long resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            mediumDao.creer(new Spirite("Gwenaëlle", "F", "Spécialiste des "
                    + "grandes conversations au-delà de TOUTES les frontières."
                    ,"Boule de cristal" 
                    ));
            mediumDao.creer(new Spirite("Professeur Tran", 
                    "H", "Votre avenir est devant vous : regardons-le ensemble !"
                    ,"Marc de café, boule de cristal, oreilles de lapin" 
                    ));
            mediumDao.creer(new Cartomancien("Mme Irma", "F", "Comprenez votre "
                    + "entourage grâce à mes cartes ! Résultats rapides."));
            mediumDao.creer(new Cartomancien("Endora", "F", "Mes cartes "
                    + "répondront à toutes vos questions personnelles."));
            mediumDao.creer(new Astrologue("Serena", "F", "Basée à "
                    + "Champigny-sur-Marne, Serena vous révèlera votre avenir "
                    + "pour éclairer votre passé.", "École Normale Supérieure "
                            + "d’Astrologie (ENS-Astro)", 2006));
            mediumDao.creer(new Astrologue("Mr M", "H", "Avenir, avenir, que "
                    + "nous réserves-tu ? N'attendez plus, demandez à me "
                    + "consulter!", "Institut des Nouveaux Savoirs Astrologiques"
                    ,2010));
            JpaUtil.validerTransaction();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service inscrireClient(client)", ex);
            JpaUtil.annulerTransaction();
            return false;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return true;
    }

    public Client rechercherClientParId(Long id) {
        Client resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            resultat = clientDao.chercherParId(id);
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service rechercherClientParId(id)", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }

    public Client authentifierClient(String mail, String motDePasse) {
        Client resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            // Recherche du client
            Client client = clientDao.chercherParMail(mail);
            if (client != null) {
                // Vérification du mot de passe
                if (client.getMotDePasse().equals(motDePasse)) {
                    resultat = client;
                }
            }
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service authentifierClient(mail,motDePasse)", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    
    public Employe authentifierEmploye(String mail, String motDePasse) {
        Employe resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            // Recherche du client
            Employe employe = employeDao.chercherParMail(mail);
            if (employe != null) {
                // Vérification du mot de passe
                if (employe.getMotDePasse().equals(motDePasse)) {
                    resultat = employe;
                }
            }
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service authentifierClient(mail,motDePasse)", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }


    public List<Client> listerClients() {
        List<Client> resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            resultat = clientDao.listerClients();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service listerClients()", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }

}
