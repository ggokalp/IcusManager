/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gokalp.icus.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author My Caruba
 */
@Embeddable
public class ListedeprixPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCLIENT")
    private int idclient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "LISTENOM")
    private String listenom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDARTICLE")
    private int idarticle;

    public ListedeprixPK() {
    }

    public ListedeprixPK(int idclient, String listenom, int idarticle) {
        this.idclient = idclient;
        this.listenom = listenom;
        this.idarticle = idarticle;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public String getListenom() {
        return listenom;
    }

    public void setListenom(String listenom) {
        this.listenom = listenom;
    }

    public int getIdarticle() {
        return idarticle;
    }

    public void setIdarticle(int idarticle) {
        this.idarticle = idarticle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idclient;
        hash += (listenom != null ? listenom.hashCode() : 0);
        hash += (int) idarticle;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListedeprixPK)) {
            return false;
        }
        ListedeprixPK other = (ListedeprixPK) object;
        if (this.idclient != other.idclient) {
            return false;
        }
        if ((this.listenom == null && other.listenom != null) || (this.listenom != null && !this.listenom.equals(other.listenom))) {
            return false;
        }
        if (this.idarticle != other.idarticle) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gokalp.icus.entity.ListedeprixPK[ idclient=" + idclient + ", listenom=" + listenom + ", idarticle=" + idarticle + " ]";
    }
    
}
