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
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Garcian
 */
@ManagedBean
@SessionScoped
public class ClientJSF implements Serializable {

    @EJB
    Facade facade;

    private List<Client> client;
    private List<Client> clientFilteredSelect;
    private List<Client> clientFilteredDelete;
    private Client selected;

    public ClientJSF() {
        client = new ArrayList<>();
        selected = new Client();
        clientFilteredDelete = new ArrayList<>();
    }

    public List<Client> getClient() {
        client = (List<Client>) facade.getClient();
        return client;
    }

    public void setClient(List<Client> client) {
        this.client = client;
    }

    public Client getSelected() {
        System.out.println("get");
        return selected;
    }

    public void setSelected(Client selected) {
        System.out.println("set");
        this.selected = selected;
    }

    public List<Client> getClientFilteredSelect() {
        return clientFilteredSelect;
    }

    public void setClientFilteredSelect(List<Client> clientFilteredSelect) {
        this.clientFilteredSelect = clientFilteredSelect;
    }

    public List<Client> getClientFilteredDelete() {
        return clientFilteredDelete;
    }

    public void setClientFilteredDelete(List<Client> clientFilteredDelete) {
        this.clientFilteredDelete = clientFilteredDelete;
    }

    public void addNewClient() {
        System.out.println("ADD JSF");
        if (facade.addClient(selected)) {
            System.out.println("clean");
            selected = new Client();
        }
    }

    public String delClient() {
        System.out.println("Del JSF");
        if (facade.delClient(selected.getId())) {
            System.out.println("Delete complete");
            client = (List<Client>) facade.getClient();
        }
        return "update";
    }

    public String modifClient() {
        System.out.println("Edit JSF");
        if (facade.editClient(selected)) {
            System.out.println("Modif JSF");
            return "modifValide";
        }
        return "modifInvalide";
    }
}
