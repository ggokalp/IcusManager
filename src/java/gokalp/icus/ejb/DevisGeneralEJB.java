/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gokalp.icus.ejb;

import gokalp.icus.entity.Devisgeneral;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author My Caruba
 */
public class DevisGeneralEJB {

    @PersistenceContext(unitName="IcusManagerPU")
    private EntityManager em;
    
    public Collection<Devisgeneral> getDevis() {
        Query query = em.createNamedQuery("Devisgeneral.findAll");
        Collection<Devisgeneral> devis = query.getResultList();
        return devis;
    }
    
    public Collection<Devisgeneral> getDevis(int idClient) {
        Query query = em.createNamedQuery("Devisgeneral.findByIdclient");
        query.setParameter("idclient", idClient);
        Collection<Devisgeneral> devis = query.getResultList();
        return devis;
    }
    
    public Collection<Devisgeneral> getDevis(String nomClient) {
        Query query = em.createNamedQuery("Devisgeneral.findBySociete");
        query.setParameter("societe", nomClient);
        Collection<Devisgeneral> devis = query.getResultList();
        return devis;
    }
    
}
