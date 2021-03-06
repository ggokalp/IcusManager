/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gokalp.icus.ejb;

import com.google.common.collect.Iterables;
import gokalp.icus.entity.Devisgeneral;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author My Caruba
 */
@Stateless
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
        Iterables.get(devis,0).getDevisdetailsCollection().size();
        return devis;
    }
    
    public Collection<Devisgeneral> getDevis(String nomClient) {
        Query query = em.createNamedQuery("Devisgeneral.findBySociete");
        query.setParameter("societe", nomClient);
        Collection<Devisgeneral> devis = query.getResultList();
        Iterables.get(devis,0).getDevisdetailsCollection().size();
        return devis;
    }
    
    public boolean addDevis(Devisgeneral devis){
        System.out.println("Add devis general ejb");
        em.persist(devis);
        return true;
    }
    
    public boolean delDevis(int iddevis){
        System.out.println("Del devis general ejb");
        Devisgeneral devis = em.find(Devisgeneral.class, iddevis);
        if(devis != null){
            em.remove(devis);
            return true;
        }
        return false;
    }
    
    public boolean editDevis(Devisgeneral devis){
        System.out.println("Update devis general ejb");
        if(devis != null){
            em.merge(devis);
            return true;
        }
        return false;
    }
    
    public Devisgeneral cloneDevis(Devisgeneral devis){
        System.out.println("Clone devis general ejb");
        if(devis != null){
            devis.setId(null);
            
            em.persist(devis);
            // We want to get the new duplicated object
            em.flush();
            return devis;
        }
        return null;
    }
}
