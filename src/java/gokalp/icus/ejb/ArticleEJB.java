package gokalp.icus.ejb;

import gokalp.icus.entity.Article;
import gokalp.icus.entity.Listedeprix;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
    
    public List<Article> getArticles(List<Listedeprix> list){
        System.out.println("get articles ejb");
        Query query = em.createNamedQuery("Article.findById");
        List<Article> article = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            query.setParameter("id", list.get(i).getListedeprixPK().getIdarticle());
            article.add((Article) query.getSingleResult());
        }
        return article;
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
