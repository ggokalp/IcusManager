package gokalp.icus.facade;

import gokalp.icus.ejb.ClientEJB;
import gokalp.icus.ejb.MenuEJB;
import gokalp.icus.entity.Client;
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
    @EJB
    private ClientEJB clientEJB;

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
}