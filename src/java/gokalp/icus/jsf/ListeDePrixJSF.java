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
    private List<String> listedenoms;
    private List<Article> listeArticle;
    private String nom;
    private String nouveauNom;
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

    public List<String> getListedenoms() {
        System.out.println("get liste de noms JSF");
        if (listedenoms.isEmpty()) {
            listedenoms = (List<String>) facade.getListeDeNoms(idClient);
        }
        System.out.println(listedenoms.size());
        return listedenoms;
    }

    public void setListedenoms(List<String> listedenoms) {
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
        this.nom = "";
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

    public String getNouveauNom() {
        return nouveauNom;
    }

    public void setNouveauNom(String nouveauNom) {
        this.nouveauNom = nouveauNom;
    }

    public int getIdClient() {
        return idClient;
    }

    public void addArticle(Article selectedArticle) {
        Listedeprix l = new Listedeprix(idClient, nom, selectedArticle.getId());
        l.setFamille(selectedArticle.getFamille());
        l.setLibelle(selectedArticle.getLibellefrl());
        l.setPrixvente(selectedArticle.getPrixvente());
        facade.addListeDePrix(l);
        this.listedeprix.clear();
    }

    public void onRowEdit(RowEditEvent event) {
        System.out.println(((Listedeprix) event.getObject()).getPrixvente());
        facade.editListeDePrix((Listedeprix) event.getObject());
    }

    public void addList() {
        if (!this.nouveauNom.isEmpty()) {
            this.nom = this.nouveauNom;
        }
        this.listedenoms.add(nom);
        this.listedeprix.clear();
        this.nouveauNom = "";
    }

}
