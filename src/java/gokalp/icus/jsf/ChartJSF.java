package gokalp.icus.jsf;

import gokalp.icus.entity.Devisdetails;
import gokalp.icus.entity.DevisdetailsDataModel;
import gokalp.icus.entity.Devisgeneral;
import gokalp.icus.facade.Facade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

@ManagedBean
@SessionScoped
public class ChartJSF implements Serializable {

    @EJB
    Facade facade;
    private CartesianChartModel model;
    private List<Devisgeneral> bigTenDevis;

    public ChartJSF() {
        model = new CartesianChartModel();

    }

    @PostConstruct
    public void init() {
        bigTenDevis = new ArrayList<>();
        bigTenDevis = (List<Devisgeneral>) facade.getBigTenDevis();

        ChartSeries chartSeries = new ChartSeries();

        chartSeries.setLabel("Top 10 DEVIS");
        model.addSeries(chartSeries);
        String nomSociete = "";
        for (Devisgeneral devisgeneral : bigTenDevis) {
            System.out.println(devisgeneral.getSociete() + ": " + devisgeneral.getTotalttc());
            if (devisgeneral.getSociete().length() >= 10) {
                nomSociete = devisgeneral.getSociete().substring(0, 10);
            } else {
                nomSociete = devisgeneral.getSociete();
            }
            //TODO: Only one societe can exist, need to resolve in chart
            chartSeries.set(nomSociete, devisgeneral.getTotalttc());
        }

    }

    public CartesianChartModel getModel() {
        return model;
    }

    public List<Devisgeneral> getBigTenDevis() {
        return bigTenDevis;
    }

    public void setBigTenDevis(List<Devisgeneral> bigTenDevis) {
        this.bigTenDevis = bigTenDevis;
    }

}
