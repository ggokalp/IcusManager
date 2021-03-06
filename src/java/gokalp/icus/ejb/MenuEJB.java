package gokalp.icus.ejb;

import gokalp.icus.entity.Menu;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Gabriel
 */
@Stateless
public class MenuEJB {

    @PersistenceContext(unitName = "IcusManagerPU")
    private EntityManager em;

    public Collection<Menu> getMenus() {
        System.out.println("ejb menu");
        Query query = em.createNamedQuery("Menu.findAll");
        Collection<Menu> menu = query.getResultList();
        System.out.println("MenuEJB: getMenus() : ejb fin getmenu");
        return menu;
    }
}
