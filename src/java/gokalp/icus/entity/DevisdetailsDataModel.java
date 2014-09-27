/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gokalp.icus.entity;

import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author My Caruba
 */
public class DevisdetailsDataModel extends ListDataModel<Devisdetails> implements SelectableDataModel<Devisdetails>{

    public DevisdetailsDataModel() {
    }

    public DevisdetailsDataModel(List<Devisdetails> list) {
        super(list);
        System.out.println("list taille : "+list.size());
    }
    
    @Override
    public Object getRowKey(Devisdetails t) {
        return t.getId();
    }

    @Override
    public Devisdetails getRowData(String string) {
        List<Devisdetails> devis = (List<Devisdetails>) getWrappedData();
        
        for(Devisdetails d : devis){
            if(d.getId()== Integer.parseInt(string))
                return d;
        }
        
        return null;
    }
    
}
