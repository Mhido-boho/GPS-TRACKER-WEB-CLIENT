/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EL MAHDI
 */
@Entity
@Table(name = "vehiculegpstracker")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehiculeGPSTracker.findAll", query = "SELECT v FROM VehiculeGPSTracker v")
    , @NamedQuery(name = "VehiculeGPSTracker.findByGPSTrackerid", query = "SELECT v FROM VehiculeGPSTracker v WHERE v.vehiculeGPSTrackerPK.gPSTrackerid = :gPSTrackerid")
    , @NamedQuery(name = "VehiculeGPSTracker.findByVehiculeid", query = "SELECT v FROM VehiculeGPSTracker v WHERE v.vehiculeGPSTrackerPK.vehiculeid = :vehiculeid")
    , @NamedQuery(name = "VehiculeGPSTracker.findByDateDebut", query = "SELECT v FROM VehiculeGPSTracker v WHERE v.dateDebut = :dateDebut")
    , @NamedQuery(name = "VehiculeGPSTracker.findByDateFin", query = "SELECT v FROM VehiculeGPSTracker v WHERE v.dateFin = :dateFin")})
public class VehiculeGPSTracker implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VehiculeGPSTrackerPK vehiculeGPSTrackerPK;
    @Column(name = "dateDebut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Column(name = "dateFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    @JoinColumn(name = "Vehicule_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Vehicule vehicule;
    @JoinColumn(name = "GPSTracker_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private GPSTracker gPSTracker;

    public VehiculeGPSTracker() {
    }

    public VehiculeGPSTracker(VehiculeGPSTrackerPK vehiculeGPSTrackerPK) {
        this.vehiculeGPSTrackerPK = vehiculeGPSTrackerPK;
    }

    public VehiculeGPSTracker(int gPSTrackerid, int vehiculeid) {
        this.vehiculeGPSTrackerPK = new VehiculeGPSTrackerPK(gPSTrackerid, vehiculeid);
    }

    public VehiculeGPSTrackerPK getVehiculeGPSTrackerPK() {
        return vehiculeGPSTrackerPK;
    }

    public void setVehiculeGPSTrackerPK(VehiculeGPSTrackerPK vehiculeGPSTrackerPK) {
        this.vehiculeGPSTrackerPK = vehiculeGPSTrackerPK;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public GPSTracker getGPSTracker() {
        return gPSTracker;
    }

    public void setGPSTracker(GPSTracker gPSTracker) {
        this.gPSTracker = gPSTracker;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vehiculeGPSTrackerPK != null ? vehiculeGPSTrackerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehiculeGPSTracker)) {
            return false;
        }
        VehiculeGPSTracker other = (VehiculeGPSTracker) object;
        if ((this.vehiculeGPSTrackerPK == null && other.vehiculeGPSTrackerPK != null) || (this.vehiculeGPSTrackerPK != null && !this.vehiculeGPSTrackerPK.equals(other.vehiculeGPSTrackerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.VehiculeGPSTracker[ vehiculeGPSTrackerPK=" + vehiculeGPSTrackerPK + " ]";
    }
    
}
