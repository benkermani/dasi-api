/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insalyon.dasi.metier.modele;

import java.io.Serializable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Benjamin
 */

/*
Nous ne specifions pas la directive @DiscriminatorValue puisque la stratégie
utilisée par défaut nous convient
*/

@DiscriminatorColumn(name="TYPE")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Entity//les champs sont persistés et il n'est pas possible d'effectuer des requêtes
public abstract class Medium implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String denomination;
    protected String genre;
    protected String presentation;
    
    
    
    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public Long getId() {
        return id;
    }
    
    abstract public String toString();
            
}
