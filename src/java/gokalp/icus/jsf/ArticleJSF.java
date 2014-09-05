/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gokalp.icus.jsf;

import gokalp.icus.entity.Article;
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
public class ArticleJSF implements Serializable{
    @EJB
    Facade facade;
    
    private List<Article> articles;
    private List<Article> articlesFilteredSelect;
    private List<Article> articlesFilteredDelete;
    private Article selected;
    private Article article;

    public ArticleJSF() {
        articles = new ArrayList<>();
        articlesFilteredSelect = new ArrayList<>();
        articlesFilteredDelete = new ArrayList<>();
        selected = new Article();
        article = new Article();
    }

    public List<Article> getArticles() {
        System.out.println("get");
        articles = (List<Article>) facade.getArticles();
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Article> getArticlesFilteredSelect() {
        return articlesFilteredSelect;
    }

    public void setArticlesFilteredSelect(List<Article> articlesFilteredSelect) {
        this.articlesFilteredSelect = articlesFilteredSelect;
    }

    public List<Article> getArticlesFilteredDelete() {
        return articlesFilteredDelete;
    }

    public void setArticlesFilteredDelete(List<Article> articlesFilteredDelete) {
        this.articlesFilteredDelete = articlesFilteredDelete;
    }

    public Article getSelected() {
        return selected;
    }

    public void setSelected(Article selected) {
        this.selected = selected;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
    
    public void addNewArticle(){
        System.out.println("ADD JSF");
        if(facade.addArticle(article)){
            article = new Article();
        }
    }
    
    public void delArticle(){
        System.out.println("Del JSF");
        if(facade.delArticle(selected.getId())){
            articles = (List<Article>) facade.getArticles();
        }
    }
    
    public String modifArticle(){
        System.out.println("Edit JSF");
        if(facade.editArticle(selected)){
            System.out.println("Modif JSF");
            return "valideArticle";
        }
        return "invalideArticle";
    }
}
