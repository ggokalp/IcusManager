/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gokalp.icus.jsf;

import com.sun.xml.ws.developer.Serialization;
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
    private Devisgeneral selected;
    private Devisgeneral clone;
    private Client client;
    private boolean edit;

    public DevisJSF() {
        devisg = new ArrayList<>();
        edit = false;
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
    }

    public String setClient(Client client) {
        this.client = client;
        return "voirdevis";
    }
    
    public String ajouterDevis(){
        clone = new Devisgeneral();
        edit = false;
        return "ajoutDevis";
    }
    
    public String editerDevis(){
        clone = selected;
        edit = true;
        return "ajoutDevis";
    }

    public String duppliquerDevis() {
        System.out.println("duppliquerDevis() id selected : "+selected.getId());
        clone = facade.cloneDevis(selected.copy());
        System.out.println("duppliquerDevis() id clone : "+clone.getId());
        edit = true;
        devisg = (List<Devisgeneral>) facade.getDevisGeneral();
        return "ajoutDevis";
    }

    public void supprimerDevis() {
        facade.delDevisGeneral(selected.getId());
        devisg = (List<Devisgeneral>) facade.getDevisGeneral();
    }
    
    public void appliquerModif(){
        if(edit){
            System.out.println("Edit appliquer Modif "+clone.getDateecheance());
            facade.editDevisGeneral(clone);
        }else{
            facade.addDevisGeneral(clone);
        }
        devisg = (List<Devisgeneral>) facade.getDevisGeneral();
    }
}
