package gokalp.icus.facade;

import gokalp.icus.ejb.ArticleEJB;
import gokalp.icus.ejb.ClientEJB;
import gokalp.icus.ejb.ListeDePrixEJB;
import gokalp.icus.ejb.MenuEJB;
import gokalp.icus.entity.Article;
import gokalp.icus.entity.Client;
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
}