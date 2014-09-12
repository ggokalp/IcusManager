package gokalp.icus.facade;

import gokalp.icus.ejb.ArticleEJB;
import gokalp.icus.ejb.ClientEJB;
import gokalp.icus.ejb.DevisDetailsEJB;
import gokalp.icus.ejb.DevisGeneralEJB;
import gokalp.icus.ejb.ListeDePrixEJB;
import gokalp.icus.ejb.MenuEJB;
import gokalp.icus.entity.Article;
import gokalp.icus.entity.Client;
import gokalp.icus.entity.Devisgeneral;
import gokalp.icus.entity.Devisdetails;
import gokalp.icus.entity.Listedeprix;
import gokalp.icus.entity.Menu;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 * @author Gabriel
 */
@Stateful
public class Facade {

    @EJB
    private MenuEJB menuEJB;
    @EJB
    private ClientEJB clientEJB;
    @EJB
    private ArticleEJB  articleEJB;
    @EJB
    private ListeDePrixEJB listeEJB;
    @EJB
    private DevisGeneralEJB devisGEJB;
    @EJB
    private DevisDetailsEJB devisDEJB;

    public Collection<Menu> getMenu() {
        System.out.println("facade menu");
        return menuEJB.getMenus();
    }
    
    public Collection<Client> getClient(){
        return clientEJB.getClients();
    }
    
    public boolean addClient(Client client){
        System.out.println("Add Facade");
        return clientEJB.addClient(client);
    }

    public boolean delClient(int selectedId) {
        System.out.println("Delete Facade");
        return clientEJB.delClient(selectedId);
    }

    public boolean editClient(Client client) {
        System.out.println("Edit Facade");
        return clientEJB.editClient(client);
    }
    
    public Collection<Article> getArticles(){
        return articleEJB.getArticles();
    }

    public boolean addArticle(Article article) {
        System.out.println("Add Facade");
        return articleEJB.addArticle(article);
    }
    
    public boolean delArticle(int idArticle){
        System.out.println("Delete Facade");
        return articleEJB.delArticle(idArticle);
    }
    
    public boolean editArticle(Article article){
        System.out.println("Edit Facade");
        return articleEJB.editArticle(article);
    }
    
    public Collection<Listedeprix> getListesDePrix(){
        return listeEJB.getListesDePrix();
    }
    
    public Collection<Listedeprix> getListesDePrix(int idClient){
        return listeEJB.getListeDePrix(idClient);
    }
    
    public Collection<Listedeprix> getListesDePrix(int idClient, String nom){
        return listeEJB.getListeDePrix(idClient,nom);
    }
    
    public Collection<String> getListeDeNoms(int idClient){
        return listeEJB.getListeDeNoms(idClient);
    }
    
    public List<Article> getArticles(List<Listedeprix> list){
        System.out.println("get articles facade");
        return articleEJB.getArticles(list);
    }
    
    public boolean addListeDePrix(Listedeprix liste){
        return listeEJB.addListeDePrix(liste);
    }
    
    public boolean delListeDePrix(Listedeprix liste){
        return listeEJB.delListeDePrix(liste);
    }
    
    public boolean editListeDePrix(Listedeprix liste){
        return listeEJB.editListeDePrix(liste);
    }
    
    public Collection<Devisgeneral> getDevisGeneral(){
        return devisGEJB.getDevis();
    }
    
    public Collection<Devisgeneral> getDevisGeneral(int idClient){
        return devisGEJB.getDevis(idClient);
    }
    
    public Collection<Devisgeneral> getDevisGeneral(String nomClient){
        return devisGEJB.getDevis(nomClient);
    }
    
    public boolean addDevisGeneral(Devisgeneral devis){
        return devisGEJB.addDevis(devis);
    }
    
    public boolean delDevisGeneral(int iddevis){
        return devisGEJB.delDevis(iddevis);
    }
    
    public boolean editDevisGeneral(Devisgeneral devis){
        return devisGEJB.editDevis(devis);
    }
    
    public Collection<Devisdetails> getDevisDetails(){
        return devisDEJB.getDevis();
    }
    
    public Collection<Devisdetails> getDevisDetails(int iddevis){
        return devisDEJB.getDevis(iddevis);
    }
}