/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gokalp.icus.ejb;

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
public class DevisDetailsEJB {
    @PersistenceContext(unitName="IcusManagerPU")
    private EntityManager em;
    
    public Collection<Devisgeneral> getDevis() {
        Query query = em.createNamedQuery("Devisgeneral.findAll");
        Collection<Devisgeneral> devis = query.getResultList();
        return devis;
    }
}
