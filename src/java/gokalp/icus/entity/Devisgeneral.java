/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gokalp.icus.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author My Caruba
 */
@Entity
@Table(name = "DEVISGENERAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Devisgeneral.findAll", query = "SELECT d FROM Devisgeneral d"),
    @NamedQuery(name = "Devisgeneral.findById", query = "SELECT d FROM Devisgeneral d WHERE d.id = :id"),
    @NamedQuery(name = "Devisgeneral.findByNopiece", query = "SELECT d FROM Devisgeneral d WHERE d.nopiece = :nopiece"),
    @NamedQuery(name = "Devisgeneral.findByDatepiece", query = "SELECT d FROM Devisgeneral d WHERE d.datepiece = :datepiece"),
    @NamedQuery(name = "Devisgeneral.findByStatus", query = "SELECT d FROM Devisgeneral d WHERE d.status = :status"),
    @NamedQuery(name = "Devisgeneral.findByDateecheance", query = "SELECT d FROM Devisgeneral d WHERE d.dateecheance = :dateecheance"),
    @NamedQuery(name = "Devisgeneral.findByIdclient", query = "SELECT d FROM Devisgeneral d WHERE d.idclient = :idclient"),
    @NamedQuery(name = "Devisgeneral.findBySociete", query = "SELECT d FROM Devisgeneral d WHERE d.societe = :societe"),
    @NamedQuery(name = "Devisgeneral.findByCodetarif", query = "SELECT d FROM Devisgeneral d WHERE d.codetarif = :codetarif"),
    @NamedQuery(name = "Devisgeneral.findByRefer", query = "SELECT d FROM Devisgeneral d WHERE d.refer = :refer"),
    @NamedQuery(name = "Devisgeneral.findByRemarque", query = "SELECT d FROM Devisgeneral d WHERE d.remarque = :remarque"),
    @NamedQuery(name = "Devisgeneral.findByTransfere", query = "SELECT d FROM Devisgeneral d WHERE d.transfere = :transfere"),
    @NamedQuery(name = "Devisgeneral.findByDerniertransfert", query = "SELECT d FROM Devisgeneral d WHERE d.derniertransfert = :derniertransfert"),
    @NamedQuery(name = "Devisgeneral.findByTotalht", query = "SELECT d FROM Devisgeneral d WHERE d.totalht = :totalht"),
    @NamedQuery(name = "Devisgeneral.findByTotaltva", query = "SELECT d FROM Devisgeneral d WHERE d.totaltva = :totaltva"),
    @NamedQuery(name = "Devisgeneral.findByTotalttc", query = "SELECT d FROM Devisgeneral d WHERE d.totalttc = :totalttc")})
public class Devisgeneral implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "NOPIECE")
    private String nopiece;
    @Size(max = 15)
    @Column(name = "DATEPIECE")
    private String datepiece;
    @Size(max = 10)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 10)
    @Column(name = "DATEECHEANCE")
    private String dateecheance;
    @Column(name = "IDCLIENT")
    private Integer idclient;
    @Size(max = 100)
    @Column(name = "SOCIETE")
    private String societe;
    @Size(max = 100)
    @Column(name = "CODETARIF")
    private String codetarif;
    @Size(max = 100)
    @Column(name = "REFER")
    private String refer;
    @Size(max = 1000)
    @Column(name = "REMARQUE")
    private String remarque;
    @Size(max = 10)
    @Column(name = "TRANSFERE")
    private String transfere;
    @Size(max = 20)
    @Column(name = "DERNIERTRANSFERT")
    private String derniertransfert;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTALHT")
    private Double totalht;
    @Column(name = "TOTALTVA")
    private Double totaltva;
    @Column(name = "TOTALTTC")
    private Double totalttc;

    public Devisgeneral() {
    }

    public Devisgeneral(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNopiece() {
        return nopiece;
    }

    public void setNopiece(String nopiece) {
        this.nopiece = nopiece;
    }

    public String getDatepiece() {
        return datepiece;
    }

    public void setDatepiece(String datepiece) {
        this.datepiece = datepiece;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateecheance() {
        return dateecheance;
    }

    public void setDateecheance(String dateecheance) {
        this.dateecheance = dateecheance;
    }

    public Integer getIdclient() {
        return idclient;
    }

    public void setIdclient(Integer idclient) {
        this.idclient = idclient;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    public String getCodetarif() {
        return codetarif;
    }

    public void setCodetarif(String codetarif) {
        this.codetarif = codetarif;
    }

    public String getRefer() {
        return refer;
    }

    public void setRefer(String refer) {
        this.refer = refer;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public String getTransfere() {
        return transfere;
    }

    public void setTransfere(String transfere) {
        this.transfere = transfere;
    }

    public String getDerniertransfert() {
        return derniertransfert;
    }

    public void setDerniertransfert(String derniertransfert) {
        this.derniertransfert = derniertransfert;
    }

    public Double getTotalht() {
        return totalht;
    }

    public void setTotalht(Double totalht) {
        this.totalht = totalht;
    }

    public Double getTotaltva() {
        return totaltva;
    }

    public void setTotaltva(Double totaltva) {
        this.totaltva = totaltva;
    }

    public Double getTotalttc() {
        return totalttc;
    }

    public void setTotalttc(Double totalttc) {
        this.totalttc = totalttc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Devisgeneral)) {
            return false;
        }
        Devisgeneral other = (Devisgeneral) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gokalp.icus.entity.Devisgeneral[ id=" + id + " ]";
    }
    
}
