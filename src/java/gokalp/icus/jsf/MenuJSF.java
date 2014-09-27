package gokalp.icus.jsf;

import gokalp.icus.entity.Menu;
import gokalp.icus.facade.Facade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.DashboardReorderEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

/**
 *
 * @author Tom De Man
 */
@ManagedBean
@ViewScoped
public class MenuJSF implements Serializable {

    @EJB
    Facade facade;
    private List<Menu> menu;
    private DashboardModel model;

    public MenuJSF() {
        menu = new ArrayList<>();
    }

    public List<Menu> getMenu() {
        if (menu.isEmpty()) {
            System.out.println("Load");
            menu = (List<Menu>) facade.getMenu();
        }
        System.out.println("Menu: " + menu.size());
        return menu;
    }

    //DashBoard Begin
    @PostConstruct
    public void init() {
        model = new DefaultDashboardModel();
        DashboardColumn column1 = new DefaultDashboardColumn();
        DashboardColumn column2 = new DefaultDashboardColumn();
        
        column1.addWidget(getMenu().get(0).getCode());
        column1.addWidget(getMenu().get(1).getCode());
        column1.addWidget(getMenu().get(2).getCode());
        column1.addWidget(getMenu().get(3).getCode());
        
        column2.addWidget(getMenu().get(4).getCode());
        column2.addWidget(getMenu().get(5).getCode());
        column2.addWidget(getMenu().get(6).getCode());
        column2.addWidget(getMenu().get(7).getCode());

        model.addColumn(column1);
        model.addColumn(column2);
    }

    public void handleReorder(DashboardReorderEvent event) {
        FacesMessage message = new FacesMessage();
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        message.setSummary("Reordered: " + event.getWidgetId());
        message.setDetail("Item index: " + event.getItemIndex() + ", Column index: " + event.getColumnIndex() + ", Sender index: " + event.getSenderColumnIndex());

        addMessage(message);
    }

    public void handleClose(CloseEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Panel Closed", "Closed panel id:'" + event.getComponent().getId() + "'");

        addMessage(message);
    }

    public void handleToggle(ToggleEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, event.getComponent().getId() + " toggled", "Status:" + event.getVisibility().name());

        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public DashboardModel getModel() {
        return model;
    }
    //DashBoard END
}
