package gokalp.icus.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author My Caruba
 */
@Entity
@Table(name = "LISTEDEPRIX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listedeprix.findAll", query = "SELECT l FROM Listedeprix l"),
    @NamedQuery(name = "Listedeprix.findByIdclient", query = "SELECT l FROM Listedeprix l WHERE l.listedeprixPK.idclient = :idclient"),
    @NamedQuery(name = "Listedeprix.findListeNomByIdclient", query = "SELECT Distinct(l.listedeprixPK.listenom) FROM Listedeprix l WHERE l.listedeprixPK.idclient = :idclient"),
    @NamedQuery(name = "Listedeprix.findByListenom", query = "SELECT l FROM Listedeprix l WHERE l.listedeprixPK.listenom = :listenom"),
    @NamedQuery(name = "Listedeprix.findByIdarticle", query = "SELECT l FROM Listedeprix l WHERE l.listedeprixPK.idarticle = :idarticle"),
    @NamedQuery(name = "Listedeprix.findByLibelle", query = "SELECT l FROM Listedeprix l WHERE l.libelle = :libelle"),
    @NamedQuery(name = "Listedeprix.findByFamille", query = "SELECT l FROM Listedeprix l WHERE l.famille = :famille"),
    @NamedQuery(name = "Listedeprix.findByPrixvente", query = "SELECT l FROM Listedeprix l WHERE l.prixvente = :prixvente"),
    @NamedQuery(name = "Listedeprix.findByListenomAndIdClient", query = "SELECT l FROM Listedeprix l WHERE l.listedeprixPK.idclient = :idclient AND l.listedeprixPK.listenom = :listenom")})
public class Listedeprix implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ListedeprixPK listedeprixPK;
    @Size(max = 1500)
    @Column(name = "LIBELLE")
    private String libelle;
    @Column(name = "FAMILLE")
    private String famille;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIXVENTE")
    private double prixvente;

    public Listedeprix() {
    }

    public Listedeprix(ListedeprixPK listedeprixPK) {
        this.listedeprixPK = listedeprixPK;
    }

    public Listedeprix(ListedeprixPK listedeprixPK, double prixvente) {
        this.listedeprixPK = listedeprixPK;
        this.prixvente = prixvente;
    }

    public Listedeprix(int idclient, String listenom, int idarticle) {
        this.listedeprixPK = new ListedeprixPK(idclient, listenom, idarticle);
    }

    public ListedeprixPK getListedeprixPK() {
        return listedeprixPK;
    }

    public void setListedeprixPK(ListedeprixPK listedeprixPK) {
        this.listedeprixPK = listedeprixPK;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public double getPrixvente() {
        return prixvente;
    }

    public void setPrixvente(double prixvente) {
        this.prixvente = prixvente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (listedeprixPK != null ? listedeprixPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Listedeprix)) {
            return false;
        }
        Listedeprix other = (Listedeprix) object;
        if ((this.listedeprixPK == null && other.listedeprixPK != null) || (this.listedeprixPK != null && !this.listedeprixPK.equals(other.listedeprixPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gokalp.icus.entity.Listedeprix[ listedeprixPK=" + listedeprixPK + " ]";
    }
    
}
