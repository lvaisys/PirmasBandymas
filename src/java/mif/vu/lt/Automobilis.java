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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Laurynas
 */
@Entity
@Table(name = "AUTOMOBILIS")
@NamedQueries({
    @NamedQuery(name = "Automobilis.findAll", query = "SELECT a FROM Automobilis a"),
    @NamedQuery(name = "Automobilis.findById", query = "SELECT a FROM Automobilis a WHERE a.id = :id"),
    @NamedQuery(name = "Automobilis.findByMarke", query = "SELECT a FROM Automobilis a WHERE a.marke = :marke"),
    @NamedQuery(name = "Automobilis.findByModelis", query = "SELECT a FROM Automobilis a WHERE a.modelis = :modelis"),
    @NamedQuery(name = "Automobilis.findByVin", query = "SELECT a FROM Automobilis a WHERE a.vin = :vin"),
    @NamedQuery(name = "Automobilis.findByOptLockVersion", query = "SELECT a FROM Automobilis a WHERE a.optLockVersion = :optLockVersion")})
public class Automobilis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "MARKE")
    private String marke;
    @Size(max = 50)
    @Column(name = "MODELIS")
    private String modelis;
    @Size(max = 17)
    @Column(name = "VIN")
    private String vin;
    @Column(name = "OPT_LOCK_VERSION")
    private Integer optLockVersion;
    @ManyToMany(mappedBy = "automobilisList")
    private List<Klientas> klientasList;
    @JoinColumn(name = "FIRMOS_ID", referencedColumnName = "ID")
    @ManyToOne
    private Firma firmosId;

    public Automobilis() {
    }

    public Automobilis(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getModelis() {
        return modelis;
    }

    public void setModelis(String modelis) {
        this.modelis = modelis;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getOptLockVersion() {
        return optLockVersion;
    }

    public void setOptLockVersion(Integer optLockVersion) {
        this.optLockVersion = optLockVersion;
    }

    public List<Klientas> getKlientasList() {
        return klientasList;
    }

    public void setKlientasList(List<Klientas> klientasList) {
        this.klientasList = klientasList;
    }

    public Firma getFirmosId() {
        return firmosId;
    }

    public void setFirmosId(Firma firmosId) {
        this.firmosId = firmosId;
    }

    @Override
    public int hashCode() {
        return vin.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Automobilis)) {
            return false;
        }
        Automobilis other = (Automobilis) object;
        if ((this.id == null && other.id != null) || (this.vin != null && !this.vin.equals(other.vin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mif.vu.lt.Automobilis[ id=" + id + " ]";
    }
    
}
