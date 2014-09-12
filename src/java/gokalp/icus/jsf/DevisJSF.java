/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gokalp.icus.jsf;

import gokalp.icus.entity.Client;
import gokalp.icus.entity.Devisdetails;
import gokalp.icus.entity.Devisgeneral;
import gokalp.icus.facade.Facade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author My Caruba
 */
@ManagedBean
@SessionScoped
public class DevisJSF implements Serializable {

    @EJB
    private Facade facade;

    private List<Devisgeneral> devisg;
    private List<Devisdetails> devisd;
    private Devisgeneral selected;
    private Client client;

    public DevisJSF() {
        devisg = new ArrayList<>();
        devisd = new ArrayList<>();
    }

    public List<Devisgeneral> getDevisg() {
        if (devisg.isEmpty()) {
            if (client != null) {
                devisg = (List<Devisgeneral>) facade.getDevis(client.getSociete());
            } else {
                devisg = (List<Devisgeneral>) facade.getDevis();
            }
        }
        return devisg;
    }

    public void setDevisg(List<Devisgeneral> devisg) {
        this.devisg = devisg;
    }

    public List<Devisdetails> getDevisd() {
        return devisd;
    }

    public void setDevisd(List<Devisdetails> devisd) {
        this.devisd = devisd;
    }

    public Devisgeneral getSelected() {
        return selected;
    }

    public void setSelected(Devisgeneral selected) {
        this.selected = selected;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
