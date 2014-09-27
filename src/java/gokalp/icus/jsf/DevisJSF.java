/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gokalp.icus.jsf;

import gokalp.icus.entity.Article;
import gokalp.icus.entity.Client;
import gokalp.icus.entity.Devisdetails;
import gokalp.icus.entity.DevisdetailsDataModel;
import gokalp.icus.entity.Devisgeneral;
import gokalp.icus.facade.Facade;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    private Devisdetails selecteddd;
    private Client client;
    private Client nouveauClient;
    private boolean edit;
    private Date dateClone;
    public DevisdetailsDataModel devisModel;

    public DevisJSF() {
        devisg = new ArrayList<>();
        edit = false;
        dateClone = new Date();
        clone = new Devisgeneral();
        nouveauClient = new Client();
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

    public DevisdetailsDataModel getDevisModel() {
        return devisModel;
    }

    public void setDevisModel(DevisdetailsDataModel devisModel) {
        this.devisModel = devisModel;
    }

    public String setClient(Client client) {
        this.client = client;
        return "voirdevis";
    }

    public Client getClient() {
        return client;
    }

    public Client getNouveauClient() {
        return nouveauClient;
    }

    public void setNouveauClient(Client nouveauClient) {
        this.nouveauClient = nouveauClient;
    }

    public Devisdetails getSelecteddd() {
        return selecteddd;
    }

    public void setSelecteddd(Devisdetails selecteddd) {
        this.selecteddd = selecteddd;
    }

    public String ajouterDevis() {
        clone = new Devisgeneral();
        edit = false;
        return "ajoutDevis";
    }

    public String editerDevis() {
        System.out.println("editerDevis()");
        clone = selected;
        devisModel = new DevisdetailsDataModel((List<Devisdetails>) clone.getDevisdetailsCollection());
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

    public void ajouterDevisDetails(Article article) {
        System.out.println("Article à ajouter : " + article.getLibellefrl());
        Devisdetails devisd = new Devisdetails();
        devisd.setArticle(article.getLibellefrl());
        devisd.setQuantite(1);
        devisd.setPrixht(article.getPrixvente());
        devisd.setPrixtotht(article.getPrixvente());
        devisd.setNopiece("RFP" + (new Date()).getYear() + article.getId());
        devisd.setIddevis(clone);
        clone.getDevisdetailsCollection().add(devisd);
    }

    public void supprimerDevisDetails() {
        clone.getDevisdetailsCollection().remove(selecteddd);
    }
}
