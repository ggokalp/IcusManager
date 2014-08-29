/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gokalp.icus.jsf;

import gokalp.icus.entity.Article;
import gokalp.icus.facade.Facade;
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
public class ArticleJSF {
    @EJB
    Facade facade;
    
    private List<Article> articles;
    private List<Article> articlesFiltered;
    private Article selected;

    public ArticleJSF() {
        articles = new ArrayList<Article>();
        articlesFiltered = new ArrayList<Article>();
        selected = new Article();
    }

    public List<Article> getArticles() {
        if(articles.isEmpty()){
            articles = (List<Article>) facade.getArticles();
        }
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Article> getArticlesFiltered() {
        return articlesFiltered;
    }

    public void setArticlesFiltered(List<Article> articlesFiltered) {
        this.articlesFiltered = articlesFiltered;
    }

    public Article getSelected() {
        return selected;
    }

    public void setSelected(Article selected) {
        this.selected = selected;
    }
    
    public void addNewArticle(){
        System.out.println("ADD JSF");
        if(facade.addArticle(selected)){
            selected = new Article();
        }
    }
    
    public void delArticle(){
        System.out.println("Del JSF");
        if(facade.delArticle(selected.getId())){
            articles = (List<Article>) facade.getArticles();
        }
    }
    
    public void modifArticle(){
        System.out.println("Edit JSF");
        if(facade.editArticle(selected)){
            System.out.println("Modif JSF");
        }
    }
}
