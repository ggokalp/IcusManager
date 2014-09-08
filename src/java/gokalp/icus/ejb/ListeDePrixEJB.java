/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gokalp.icus.ejb;

import gokalp.icus.entity.Listedeprix;
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
public class ListeDePrixEJB {

    @PersistenceContext(unitName = "IcusManagerPU")
    private EntityManager em;

    public Collection<Listedeprix> getListesDePrix() {
        Query query = em.createNamedQuery("Listedeprix.findAll");
        Collection<Listedeprix> liste = query.getResultList();
        return liste;
    }

    public Collection<Listedeprix> getListeDePrix(int idClient) {
        Query query = em.createNamedQuery("Listedeprix.findByIdclient");
        query.setParameter("idclient", idClient);
        Collection<Listedeprix> liste = query.getResultList();
        return liste;
    }
    
    public Collection<String> getListeDeNoms(int idClient){
        Query query = em.createNamedQuery("Listedeprix.findListeNomByIdclient");
        query.setParameter("idclient", idClient);
        Collection<String> liste = query.getResultList();
        return liste;
    }
    
    public Collection<Listedeprix> getListeDePrix(int idClient, String nom){
        System.out.println("getListe de prix : id: "+idClient+ " nom: "+nom);
        Query query = em.createNamedQuery("Listedeprix.findByListenomAndIdClient");
        query.setParameter("idclient", idClient);
        query.setParameter("listenom", nom);
        Collection<Listedeprix> liste = query.getResultList();
        return liste;
    }

    public boolean addListeDePrix(Listedeprix liste) {
        if (liste != null) {
            em.persist(liste);
            return true;
        }
        return false;
    }

    public boolean delListeDePrix(Listedeprix liste) {
        Listedeprix l = em.find(Listedeprix.class, liste.getListedeprixPK());
        if (l != null) {
            em.remove(l);
            return true;
        }
        return false;
    }

    public boolean editListeDePrix(Listedeprix liste) {
        if (liste != null) {
            em.merge(liste);
            return true;
        }
        return false;
    }

}
