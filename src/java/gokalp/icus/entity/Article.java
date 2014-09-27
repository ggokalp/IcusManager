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
 * @author g.gokalp
 */
@Entity
@Table(name = "ARTICLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a"),
    @NamedQuery(name = "Article.findById", query = "SELECT a FROM Article a WHERE a.id = :id"),
    @NamedQuery(name = "Article.findByCode", query = "SELECT a FROM Article a WHERE a.code = :code"),
    @NamedQuery(name = "Article.findByLibellefrl", query = "SELECT a FROM Article a WHERE a.libellefrl = :libellefrl"),
    @NamedQuery(name = "Article.findByLibellenll", query = "SELECT a FROM Article a WHERE a.libellenll = :libellenll"),
    @NamedQuery(name = "Article.findByLibelleenl", query = "SELECT a FROM Article a WHERE a.libelleenl = :libelleenl"),
    @NamedQuery(name = "Article.findByLibellefrc", query = "SELECT a FROM Article a WHERE a.libellefrc = :libellefrc"),
    @NamedQuery(name = "Article.findByLibellenlc", query = "SELECT a FROM Article a WHERE a.libellenlc = :libellenlc"),
    @NamedQuery(name = "Article.findByLibelleenc", query = "SELECT a FROM Article a WHERE a.libelleenc = :libelleenc"),
    @NamedQuery(name = "Article.findByFamille", query = "SELECT a FROM Article a WHERE a.famille = :famille"),
    @NamedQuery(name = "Article.findByPrixachat", query = "SELECT a FROM Article a WHERE a.prixachat = :prixachat"),
    @NamedQuery(name = "Article.findByPrixvente", query = "SELECT a FROM Article a WHERE a.prixvente = :prixvente"),
    @NamedQuery(name = "Article.findByPrixventettc", query = "SELECT a FROM Article a WHERE a.prixventettc = :prixventettc"),
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
    @Column(name = "LIBELLEFRL")
    private String libellefrl;
    @Size(max = 1500)
    @Column(name = "LIBELLENLL")
    private String libellenll;
    @Size(max = 1500)
    @Column(name = "LIBELLEENL")
    private String libelleenl;
    @Size(max = 250)
    @Column(name = "LIBELLEFRC")
    private String libellefrc;
    @Size(max = 250)
    @Column(name = "LIBELLENLC")
    private String libellenlc;
    @Size(max = 250)
    @Column(name = "LIBELLEENC")
    private String libelleenc;
    @Size(max = 20)
    @Column(name = "FAMILLE")
    private String famille;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIXACHAT")
    private double prixachat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIXVENTE")
    private double prixvente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIXVENTETTC")
    private double prixventettc;
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

    public Article(Integer id, String code, double prixachat, double prixvente, double prixventettc) {
        this.id = id;
        this.code = code;
        this.prixachat = prixachat;
        this.prixvente = prixvente;
        this.prixventettc = prixventettc;
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

    public String getLibellefrl() {
        return libellefrl;
    }

    public void setLibellefrl(String libellefrl) {
        this.libellefrl = libellefrl;
    }

    public String getLibellenll() {
        return libellenll;
    }

    public void setLibellenll(String libellenll) {
        this.libellenll = libellenll;
    }

    public String getLibelleenl() {
        return libelleenl;
    }

    public void setLibelleenl(String libelleenl) {
        this.libelleenl = libelleenl;
    }

    public String getLibellefrc() {
        return libellefrc;
    }

    public void setLibellefrc(String libellefrc) {
        this.libellefrc = libellefrc;
    }

    public String getLibellenlc() {
        return libellenlc;
    }

    public void setLibellenlc(String libellenlc) {
        this.libellenlc = libellenlc;
    }

    public String getLibelleenc() {
        return libelleenc;
    }

    public void setLibelleenc(String libelleenc) {
        this.libelleenc = libelleenc;
    }

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
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

    public double getPrixventettc() {
        return prixventettc;
    }

    public void setPrixventettc(double prixventettc) {
        this.prixventettc = prixventettc;
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
