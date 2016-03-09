/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mif.vu.lt;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Laurynas
 */
@Entity
@Table(name = "FIRMA")
@NamedQueries({
    @NamedQuery(name = "Firma.findAll", query = "SELECT f FROM Firma f"),
    @NamedQuery(name = "Firma.findById", query = "SELECT f FROM Firma f WHERE f.id = :id"),
    @NamedQuery(name = "Firma.findByPavadinimas", query = "SELECT f FROM Firma f WHERE f.pavadinimas = :pavadinimas"),
    @NamedQuery(name = "Firma.findByOptLockVersion", query = "SELECT f FROM Firma f WHERE f.optLockVersion = :optLockVersion")})
public class Firma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "PAVADINIMAS")
    private String pavadinimas;
    @Column(name = "OPT_LOCK_VERSION")
    private Integer optLockVersion;
    @OneToMany(mappedBy = "firmosId")
    private List<Automobilis> automobilisList;

    public Firma() {
    }

    public Firma(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public Integer getOptLockVersion() {
        return optLockVersion;
    }

    public void setOptLockVersion(Integer optLockVersion) {
        this.optLockVersion = optLockVersion;
    }

    public List<Automobilis> getAutomobilisList() {
        return automobilisList;
    }

    public void setAutomobilisList(List<Automobilis> automobilisList) {
        this.automobilisList = automobilisList;
    }

    @Override
    public int hashCode() {
        return pavadinimas.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Firma)) {
            return false;
        }
        Firma other = (Firma) object;
        if ((this.pavadinimas == null && other.pavadinimas != null) || (this.pavadinimas != null && !this.pavadinimas.equals(other.pavadinimas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mif.vu.lt.Firma[ id=" + id + " ]";
    }
    
}
