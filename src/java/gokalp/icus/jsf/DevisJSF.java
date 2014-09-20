/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gokalp.icus.jsf;

import gokalp.icus.entity.Client;
import gokalp.icus.entity.Devisgeneral;
import gokalp.icus.facade.Facade;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    private Devisgeneral selected;
    private Devisgeneral clone;
    private Client client;
    private boolean edit;
    private Date dateClone;

    public DevisJSF() {
        devisg = new ArrayList<>();
        edit = false;
        dateClone = new Date();
    }

    public Date getDateClone() {
        return dateClone;
    }

    public void setDateClone(Date dateClone) {
        this.dateClone = dateClone;
    }

    public List<Devisgeneral> getDevisg() {
        if (devisg.isEmpty()) {
            if (client != null) {
                devisg = (List<Devisgeneral>) facade.getDevisGeneral(client.getSociete());
            } else {
                devisg = (List<Devisgeneral>) facade.getDevisGeneral();
            }
        }
        return devisg;
    }

    public void setDevisg(List<Devisgeneral> devisg) {
        this.devisg = devisg;
    }

    public Devisgeneral getSelected() {
        return selected;
    }

    public void setSelected(Devisgeneral selected) {
        this.selected = selected;
    }

    public Devisgeneral getClone() {
        return clone;
    }

    public void setClone(Devisgeneral clone) {
        this.clone = clone;
        System.out.println("setClone: " + this.clone.getSociete());
    }

    public String setClient(Client client) {
        this.client = client;
        return "voirdevis";
    }

    public String ajouterDevis() {
        clone = new Devisgeneral();
        edit = false;
        return "ajoutDevis";
    }

    public String editerDevis() {
        clone = selected;
        edit = true;
        return "ajoutDevis";
    }

    public String duppliquerDevis() {
        System.out.println("duppliquerDevis() id selected : " + selected.getId());
        clone = facade.cloneDevis(selected.copy());
        System.out.println("duppliquerDevis() id clone : " + clone.getId());
        edit = true;
        devisg = (List<Devisgeneral>) facade.getDevisGeneral();
        return "ajoutDevis";
    }

    public void supprimerDevis() {
        facade.delDevisGeneral(selected.getId());
        devisg = (List<Devisgeneral>) facade.getDevisGeneral();
    }

    public void appliquerModif() {
            SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        if (edit) {
            //CA PUE
            clone.setDateecheance(formater.format(dateClone));
            System.out.println("Edit appliquer Modif " + clone.getDateecheance());
            facade.editDevisGeneral(clone);
        } else {
            clone.setDateecheance(formater.format(dateClone));
            System.out.println("Edit appliquer Modif " + clone.getDateecheance());
            facade.addDevisGeneral(clone);
        }
        devisg = (List<Devisgeneral>) facade.getDevisGeneral();
    }
}
