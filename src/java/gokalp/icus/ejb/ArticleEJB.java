/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gokalp.icus.ejb;

import gokalp.icus.entity.Article;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author My Caruba
 */
@Stateless
public class ArticleEJB {
    @PersistenceContext(unitName="IcusManagerPU")
    private EntityManager em;

    public Collection<Article> getArticles(){
        Query query = em.createNamedQuery("Article.findAll");
        Collection<Article> articles = query.getResultList();
        return articles;
    }
    
    public boolean addArticle(Article article) {
        System.out.println("Add EJB");
        em.persist(article);
        return true;
    }
    
    public boolean delArticle(int id){
        System.out.println("Delete EJB");
        Article article = em.find(Article.class, id);
        if(article != null){
            em.remove(article);
            return true;
        }
        return false;
    }
    
    public boolean editArticle(Article article){
        System.out.println("Update EJB");
        if(article != null){
            em.merge(article);
            return true;
        }
        return false;
    }
}
