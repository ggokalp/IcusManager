package gokalp.icus.facade;

import gokalp.icus.ejb.MenuEJB;
import gokalp.icus.entity.Menu;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 * @author Gabriel
 */
@Stateful
public class Facade {

    @EJB
    private MenuEJB menuEJB;

    public Collection<Menu> getMenu() {
        return menuEJB.getMenus();
    }
}
