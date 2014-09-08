/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gokalp.icus.ejb;

import gokalp.icus.entity.Client;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Garcian
 */
@Stateless
public class ClientEJB {

    @PersistenceContext(unitName = "IcusManagerPU")
    private EntityManager em;

    public Collection<Client> getClients() {
        Query query = em.createNamedQuery("Client.findAll");
        Collection<Client> clients = query.getResultList();
        return clients;
    }

    public boolean addClient(Client client) {
        System.out.println("Add EJB");
        em.persist(client);
        return true;
    }

    public boolean delClient(int selectedId) {
        System.out.println("Delete EJB");
        Client client = em.find(Client.class, selectedId);
        if (client != null) {
            System.out.println("remove");
            em.remove(client);
            return true;
        } else {
            return false;
        }
    }

    public boolean editClient(Client client) {
        System.out.println("UPDATE EJB");
        if (client != null) {
            em.merge(client);
            return true;
        } else {
            return false;
        }
    }
}
