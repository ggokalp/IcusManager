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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Garcian
 */
@Entity
@Table(name = "ARTICLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a"),
    @NamedQuery(name = "Article.findById", query = "SELECT a FROM Article a WHERE a.id = :id"),
    @NamedQuery(name = "Article.findByCode", query = "SELECT a FROM Article a WHERE a.code = :code"),
    @NamedQuery(name = "Article.findByLibellefr", query = "SELECT a FROM Article a WHERE a.libellefr = :libellefr"),
    @NamedQuery(name = "Article.findByLibellenl", query = "SELECT a FROM Article a WHERE a.libellenl = :libellenl"),
    @NamedQuery(name = "Article.findByLibelleen", query = "SELECT a FROM Article a WHERE a.libelleen = :libelleen"),
    @NamedQuery(name = "Article.findByFamille", query = "SELECT a FROM Article a WHERE a.famille = :famille"),
    @NamedQuery(name = "Article.findByPrixachat", query = "SELECT a FROM Article a WHERE a.prixachat = :prixachat"),
    @NamedQuery(name = "Article.findByPrixvente", query = "SELECT a FROM Article a WHERE a.prixvente = :prixvente"),
    @NamedQuery(name = "Article.findByStock", query = "SELECT a FROM Article a WHERE a.stock = :stock"),
    @NamedQuery(name = "Article.findByCompose", query = "SELECT a FROM Article a WHERE a.compose = :compose"),
    @NamedQuery(name = "Article.findByBloque", query = "SELECT a FROM Article a WHERE a.bloque = :bloque")})
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CODE")
    private String code;
    @Size(max = 1500)
    @Column(name = "LIBELLEFR")
    private String libellefr;
    @Size(max = 1500)
    @Column(name = "LIBELLENL")
    private String libellenl;
    @Size(max = 1500)
    @Column(name = "LIBELLEEN")
    private String libelleen;
    @Column(name = "FAMILLE")
    private Integer famille;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIXACHAT")
    private double prixachat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIXVENTE")
    private double prixvente;
    @Column(name = "STOCK")
    private Integer stock;
    @Column(name = "COMPOSE")
    private Integer compose;
    @Column(name = "BLOQUE")
    private Integer bloque;

    public Article() {
    }

    public Article(Integer id) {
        this.id = id;
    }

    public Article(Integer id, String code, double prixachat, double prixvente) {
        this.id = id;
        this.code = code;
        this.prixachat = prixachat;
        this.prixvente = prixvente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibellefr() {
        return libellefr;
    }

    public void setLibellefr(String libellefr) {
        this.libellefr = libellefr;
    }

    public String getLibellenl() {
        return libellenl;
    }

    public void setLibellenl(String libellenl) {
        this.libellenl = libellenl;
    }

    public String getLibelleen() {
        return libelleen;
    }

    public void setLibelleen(String libelleen) {
        this.libelleen = libelleen;
    }

    public Integer getFamille() {
        return famille;
    }

    public void setFamille(Integer famille) {
        this.famille = famille;
    }

    public double getPrixachat() {
        return prixachat;
    }

    public void setPrixachat(double prixachat) {
        this.prixachat = prixachat;
    }

    public double getPrixvente() {
        return prixvente;
    }

    public void setPrixvente(double prixvente) {
        this.prixvente = prixvente;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getCompose() {
        return compose;
    }

    public void setCompose(Integer compose) {
        this.compose = compose;
    }

    public Integer getBloque() {
        return bloque;
    }

    public void setBloque(Integer bloque) {
        this.bloque = bloque;
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
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gokalp.icus.entity.Article[ id=" + id + " ]";
    }
    
}
