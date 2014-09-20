/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gokalp.icus.ejb;

import gokalp.icus.entity.Devisdetails;
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
public class DevisDetailsEJB {
    @PersistenceContext(unitName="IcusManagerPU")
    private EntityManager em;
    
    public Collection<Devisdetails> getDevis() {
        Query query = em.createNamedQuery("Devisdetails.findAll");
        Collection<Devisdetails> devis = query.getResultList();
        return devis;
    }
    
    public Collection<Devisdetails> getDevis(int iddevis) {
        Query query = em.createNamedQuery("Devisdetails.findByIddevis");
        query.setParameter("iddevis", iddevis);
        Collection<Devisdetails> devis = query.getResultList();
        return devis;
    }
    
    public boolean addDevis(Devisdetails devis){
        System.out.println("Add devis details ejb");
        em.persist(devis);
        return true;
    }
    
    public boolean delDevis(int iddevis){
        System.out.println("Del devis details ejb");
        Devisdetails devis = em.find(Devisdetails.class, iddevis);
        if(devis != null){
            em.remove(devis);
            return true;
        }
        return false;
    }
    
    public boolean editDevis(Devisdetails devis){
        System.out.println("Update devis details ejb");
        if(devis != null){
            em.merge(devis);
            return true;
        }
        return false;
    }
}
