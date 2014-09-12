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
@Table(name = "DEVISDETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Devisdetails.findAll", query = "SELECT d FROM Devisdetails d"),
    @NamedQuery(name = "Devisdetails.findById", query = "SELECT d FROM Devisdetails d WHERE d.id = :id"),
    @NamedQuery(name = "Devisdetails.findByIddevis", query = "SELECT d FROM Devisdetails d WHERE d.iddevis = :iddevis"),
    @NamedQuery(name = "Devisdetails.findByNopiece", query = "SELECT d FROM Devisdetails d WHERE d.nopiece = :nopiece"),
    @NamedQuery(name = "Devisdetails.findByArticle", query = "SELECT d FROM Devisdetails d WHERE d.article = :article"),
    @NamedQuery(name = "Devisdetails.findByDescritpion", query = "SELECT d FROM Devisdetails d WHERE d.descritpion = :descritpion"),
    @NamedQuery(name = "Devisdetails.findByPrixht", query = "SELECT d FROM Devisdetails d WHERE d.prixht = :prixht"),
    @NamedQuery(name = "Devisdetails.findByQuantite", query = "SELECT d FROM Devisdetails d WHERE d.quantite = :quantite"),
    @NamedQuery(name = "Devisdetails.findByPrixtotht", query = "SELECT d FROM Devisdetails d WHERE d.prixtotht = :prixtotht")})
public class Devisdetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "IDDEVIS")
    private Integer iddevis;
    @Size(max = 100)
    @Column(name = "NOPIECE")
    private String nopiece;
    @Size(max = 100)
    @Column(name = "ARTICLE")
    private String article;
    @Size(max = 5000)
    @Column(name = "DESCRITPION")
    private String descritpion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRIXHT")
    private Double prixht;
    @Column(name = "QUANTITE")
    private Integer quantite;
    @Column(name = "PRIXTOTHT")
    private Double prixtotht;

    public Devisdetails() {
    }

    public Devisdetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIddevis() {
        return iddevis;
    }

    public void setIddevis(Integer iddevis) {
        this.iddevis = iddevis;
    }

    public String getNopiece() {
        return nopiece;
    }

    public void setNopiece(String nopiece) {
        this.nopiece = nopiece;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    public Double getPrixht() {
        return prixht;
    }

    public void setPrixht(Double prixht) {
        this.prixht = prixht;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Double getPrixtotht() {
        return prixtotht;
    }

    public void setPrixtotht(Double prixtotht) {
        this.prixtotht = prixtotht;
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
        if (!(object instanceof Devisdetails)) {
            return false;
        }
        Devisdetails other = (Devisdetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gokalp.icus.entity.Devisdetails[ id=" + id + " ]";
    }
    
}
