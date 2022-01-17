/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author EL MAHDI
 */
@Entity
@Table(name = "gpstracker")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GPSTracker.findAll", query = "SELECT g FROM GPSTracker g")
    , @NamedQuery(name = "GPSTracker.findById", query = "SELECT g FROM GPSTracker g WHERE g.id = :id")
    , @NamedQuery(name = "GPSTracker.findBySimNumber", query = "SELECT g FROM GPSTracker g WHERE g.simNumber = :simNumber")})
public class GPSTracker implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "simNumber")
    private String simNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gPSTracker", fetch = FetchType.EAGER)
    private List<VehiculeGPSTracker> vehiculeGPSTrackerList;
    @JoinColumn(name = "idPosition", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Position idPosition;

    public GPSTracker() {
    }

    public GPSTracker(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSimNumber() {
        return simNumber;
    }

    public void setSimNumber(String simNumber) {
        this.simNumber = simNumber;
    }

    @XmlTransient
    public List<VehiculeGPSTracker> getVehiculeGPSTrackerList() {
        return vehiculeGPSTrackerList;
    }

    public void setVehiculeGPSTrackerList(List<VehiculeGPSTracker> vehiculeGPSTrackerList) {
        this.vehiculeGPSTrackerList = vehiculeGPSTrackerList;
    }

    public Position getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(Position idPosition) {
        this.idPosition = idPosition;
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
        if (!(object instanceof GPSTracker)) {
            return false;
        }
        GPSTracker other = (GPSTracker) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.GPSTracker[ id=" + id + " ]";
    }
    
}
