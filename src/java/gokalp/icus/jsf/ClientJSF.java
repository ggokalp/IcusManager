/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gokalp.icus.jsf;

import gokalp.icus.entity.Client;
import gokalp.icus.facade.Facade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Garcian
 */
@ManagedBean
@ViewScoped
public class ClientJSF implements Serializable{
    @EJB
    Facade facade;
    
    private List<Client> client;
    private List<Client> clientFiltered;
    private Client selected;

    public ClientJSF() {
        client = new ArrayList<>();
        selected = new Client();
    }

    public List<Client> getClient() {
        if(client.isEmpty())
            client = (List<Client>) facade.getClient();
        return client;
    }

    public void setClient(List<Client> client) {
        this.client = client;
    }

    public Client getSelected() {
        return selected;
    }

    public void setSelected(Client selected) {
        this.selected = selected;
    }

    public List<Client> getClientFiltered() {
        return clientFiltered;
    }

    public void setClientFiltered(List<Client> clientFiltered) {
        this.clientFiltered = clientFiltered;
    }
    
    public void addNewClient(){
        System.out.println("ADD JSF");
        if(facade.addClient(selected)){
            selected = new Client();
        }
    }
}
