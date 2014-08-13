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
@Table(name = "CLIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findById", query = "SELECT c FROM Client c WHERE c.id = :id"),
    @NamedQuery(name = "Client.findByCode", query = "SELECT c FROM Client c WHERE c.code = :code"),
    @NamedQuery(name = "Client.findBySociete", query = "SELECT c FROM Client c WHERE c.societe = :societe"),
    @NamedQuery(name = "Client.findByFormejuridique", query = "SELECT c FROM Client c WHERE c.formejuridique = :formejuridique"),
    @NamedQuery(name = "Client.findByCategorie", query = "SELECT c FROM Client c WHERE c.categorie = :categorie"),
    @NamedQuery(name = "Client.findByPays", query = "SELECT c FROM Client c WHERE c.pays = :pays"),
    @NamedQuery(name = "Client.findByAdrue", query = "SELECT c FROM Client c WHERE c.adrue = :adrue"),
    @NamedQuery(name = "Client.findByAdville", query = "SELECT c FROM Client c WHERE c.adville = :adville"),
    @NamedQuery(name = "Client.findByAdcp", query = "SELECT c FROM Client c WHERE c.adcp = :adcp"),
    @NamedQuery(name = "Client.findByAdlivrue", query = "SELECT c FROM Client c WHERE c.adlivrue = :adlivrue"),
    @NamedQuery(name = "Client.findByAdlivville", query = "SELECT c FROM Client c WHERE c.adlivville = :adlivville"),
    @NamedQuery(name = "Client.findByAdlivcp", query = "SELECT c FROM Client c WHERE c.adlivcp = :adlivcp"),
    @NamedQuery(name = "Client.findByModereglement", query = "SELECT c FROM Client c WHERE c.modereglement = :modereglement"),
    @NamedQuery(name = "Client.findByBloque", query = "SELECT c FROM Client c WHERE c.bloque = :bloque"),
    @NamedQuery(name = "Client.findByModetva", query = "SELECT c FROM Client c WHERE c.modetva = :modetva"),
    @NamedQuery(name = "Client.findByRemise", query = "SELECT c FROM Client c WHERE c.remise = :remise"),
    @NamedQuery(name = "Client.findByRemarque", query = "SELECT c FROM Client c WHERE c.remarque = :remarque"),
    @NamedQuery(name = "Client.findByNumentreprise", query = "SELECT c FROM Client c WHERE c.numentreprise = :numentreprise"),
    @NamedQuery(name = "Client.findByRepresentant", query = "SELECT c FROM Client c WHERE c.representant = :representant"),
    @NamedQuery(name = "Client.findByDernierecommande", query = "SELECT c FROM Client c WHERE c.dernierecommande = :dernierecommande"),
    @NamedQuery(name = "Client.findByTarif", query = "SELECT c FROM Client c WHERE c.tarif = :tarif")})
public class Client implements Serializable {
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
    @Size(max = 200)
    @Column(name = "SOCIETE")
    private String societe;
    @Size(max = 20)
    @Column(name = "FORMEJURIDIQUE")
    private String formejuridique;
    @Size(max = 100)
    @Column(name = "CATEGORIE")
    private String categorie;
    @Size(max = 100)
    @Column(name = "PAYS")
    private String pays;
    @Size(max = 300)
    @Column(name = "ADRUE")
    private String adrue;
    @Size(max = 150)
    @Column(name = "ADVILLE")
    private String adville;
    @Size(max = 25)
    @Column(name = "ADCP")
    private String adcp;
    @Size(max = 300)
    @Column(name = "ADLIVRUE")
    private String adlivrue;
    @Size(max = 150)
    @Column(name = "ADLIVVILLE")
    private String adlivville;
    @Size(max = 25)
    @Column(name = "ADLIVCP")
    private String adlivcp;
    @Size(max = 20)
    @Column(name = "MODEREGLEMENT")
    private String modereglement;
    @Column(name = "BLOQUE")
    private Integer bloque;
    @Size(max = 30)
    @Column(name = "MODETVA")
    private String modetva;
    @Column(name = "REMISE")
    private Integer remise;
    @Size(max = 150)
    @Column(name = "REMARQUE")
    private String remarque;
    @Size(max = 25)
    @Column(name = "NUMENTREPRISE")
    private String numentreprise;
    @Size(max = 150)
    @Column(name = "REPRESENTANT")
    private String representant;
    @Size(max = 8)
    @Column(name = "DERNIERECOMMANDE")
    private String dernierecommande;
    @Column(name = "TARIF")
    private Integer tarif;

    public Client() {
    }

    public Client(Integer id) {
        this.id = id;
    }

    public Client(Integer id, String code) {
        this.id = id;
        this.code = code;
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

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    public String getFormejuridique() {
        return formejuridique;
    }

    public void setFormejuridique(String formejuridique) {
        this.formejuridique = formejuridique;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getAdrue() {
        return adrue;
    }

    public void setAdrue(String adrue) {
        this.adrue = adrue;
    }

    public String getAdville() {
        return adville;
    }

    public void setAdville(String adville) {
        this.adville = adville;
    }

    public String getAdcp() {
        return adcp;
    }

    public void setAdcp(String adcp) {
        this.adcp = adcp;
    }

    public String getAdlivrue() {
        return adlivrue;
    }

    public void setAdlivrue(String adlivrue) {
        this.adlivrue = adlivrue;
    }

    public String getAdlivville() {
        return adlivville;
    }

    public void setAdlivville(String adlivville) {
        this.adlivville = adlivville;
    }

    public String getAdlivcp() {
        return adlivcp;
    }

    public void setAdlivcp(String adlivcp) {
        this.adlivcp = adlivcp;
    }

    public String getModereglement() {
        return modereglement;
    }

    public void setModereglement(String modereglement) {
        this.modereglement = modereglement;
    }

    public Integer getBloque() {
        return bloque;
    }

    public void setBloque(Integer bloque) {
        this.bloque = bloque;
    }

    public String getModetva() {
        return modetva;
    }

    public void setModetva(String modetva) {
        this.modetva = modetva;
    }

    public Integer getRemise() {
        return remise;
    }

    public void setRemise(Integer remise) {
        this.remise = remise;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public String getNumentreprise() {
        return numentreprise;
    }

    public void setNumentreprise(String numentreprise) {
        this.numentreprise = numentreprise;
    }

    public String getRepresentant() {
        return representant;
    }

    public void setRepresentant(String representant) {
        this.representant = representant;
    }

    public String getDernierecommande() {
        return dernierecommande;
    }

    public void setDernierecommande(String dernierecommande) {
        this.dernierecommande = dernierecommande;
    }

    public Integer getTarif() {
        return tarif;
    }

    public void setTarif(Integer tarif) {
        this.tarif = tarif;
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gokalp.icus.entity.Client[ id=" + id + " ]";
    }
    
}
