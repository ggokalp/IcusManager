/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gokalp.icus.jsf;

/**
 *
 * @author My Caruba
 */
import gokalp.icus.entity.Article;
import gokalp.icus.entity.Listedeprix;
import gokalp.icus.facade.Facade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.RowEditEvent;

@ManagedBean
@SessionScoped
public class ListeDePrixJSF implements Serializable {

    @EJB
    Facade facade;

    private Listedeprix selected;
    private List<Listedeprix> listedeprix;
    private List<Listedeprix> listedenoms;
    private List<Article> listeArticle;
    private String nom;
    private int idClient;

    public ListeDePrixJSF() {
        selected = new Listedeprix();
        listedeprix = new ArrayList<>();
        listedenoms = new ArrayList<>();
        listeArticle = new ArrayList<>();
    }

    public Listedeprix getSelected() {
        return selected;
    }

    public void setSelected(Listedeprix selected) {
        this.selected = selected;
    }

    public List<Listedeprix> getListedeprix() {
        listedeprix = (List<Listedeprix>) facade.getListesDePrix(idClient, nom);
        return listedeprix;
    }

    public void setListedeprix(List<Listedeprix> listedeprix) {
        this.listedeprix = listedeprix;
    }

    public List<Listedeprix> getListedenoms() {
        System.out.println("get liste de noms JSF");
        if (listedenoms.isEmpty()) {
            listedenoms = (List<Listedeprix>) facade.getListesDePrix(idClient);
        }
        System.out.println(listedenoms.size());
        return listedenoms;
    }

    public void setListedenoms(List<Listedeprix> listedenoms) {
        this.listedenoms = listedenoms;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        System.out.println(nom);
        this.nom = nom;
    }

    public String setIdClient(int idClient) {
        System.out.println("idClient : " + idClient);
        this.idClient = idClient;
        this.listedeprix.clear();
        this.listedenoms.clear();
        this.listeArticle.clear();
        return "listeDePrix";
    }

    public List<Article> getListeArticle() {
        System.out.println("get liste article jsf");
        if (listeArticle.isEmpty()) {
            this.listeArticle = (List<Article>) facade.getArticles(this.getListedeprix());
        }
        return listeArticle;
    }

    public void setListeArticle(List<Article> listeArticle) {
        this.listeArticle = listeArticle;
    }

    public void addArticle(Article selectedArticle) {
        Listedeprix l = new Listedeprix(idClient, nom, selectedArticle.getId());
        l.setFamille(selectedArticle.getFamille());
        l.setLibelle(selectedArticle.getLibellefr());
        l.setPrixvente(selectedArticle.getPrixvente());
        facade.addListeDePrix(l);
    }

    public void onRowEdit(RowEditEvent event) {
        Article a = (Article) event.getObject();
        System.out.println("Nouveau prix de vente : " + a.getPrixvente());
        Listedeprix l = new Listedeprix(idClient, nom, a.getId());
        l.setFamille(a.getFamille());
        l.setLibelle(a.getLibellefr());
        l.setPrixvente(a.getPrixvente());
        facade.editListeDePrix(l);
    }
}
