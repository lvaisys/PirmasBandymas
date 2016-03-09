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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Laurynas
 */
@Entity
@Table(name = "KLIENTAS")
@NamedQueries({
    @NamedQuery(name = "Klientas.findAll", query = "SELECT k FROM Klientas k"),
    @NamedQuery(name = "Klientas.findByVardas", query = "SELECT k FROM Klientas k WHERE k.vardas = :vardas"),
    @NamedQuery(name = "Klientas.findByPavarde", query = "SELECT k FROM Klientas k WHERE k.pavarde = :pavarde"),
    @NamedQuery(name = "Klientas.findById", query = "SELECT k FROM Klientas k WHERE k.id = :id"),
    @NamedQuery(name = "Klientas.findByTelnr", query = "SELECT k FROM Klientas k WHERE k.telnr = :telnr"),
    @NamedQuery(name = "Klientas.findByOptLockVersion", query = "SELECT k FROM Klientas k WHERE k.optLockVersion = :optLockVersion")})
public class Klientas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "VARDAS")
    private String vardas;
    @Size(max = 20)
    @Column(name = "PAVARDE")
    private String pavarde;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ID")
    private String id;
    @Column(name = "TELNR")
    private Integer telnr;
    @Column(name = "OPT_LOCK_VERSION")
    private Integer optLockVersion;
    @JoinTable(name = "AUTOMOBILIS_KLIENTAS", joinColumns = {
        @JoinColumn(name = "KLIENTO_NR", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "AUTOMOBILIO_NR", referencedColumnName = "ID")})
    @ManyToMany
    private List<Automobilis> automobilisList;
    @Transient
    private String pilnasVardas;
    public Klientas() {
    }

    public Klientas(String id) {
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTelnr() {
        return telnr;
    }

    public void setTelnr(Integer telnr) {
        this.telnr = telnr;
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
        return pilnasVardas.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klientas)) {
            return false;
        }
        Klientas other = (Klientas) object;
        if ((this.pilnasVardas == null && other.pilnasVardas != null) || (this.pilnasVardas != null && !this.pilnasVardas.equals(other.pilnasVardas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mif.vu.lt.Klientas[ id=" + id + " ]";
    }
    
}
