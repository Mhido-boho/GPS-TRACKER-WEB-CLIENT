/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author EL MAHDI
 */
@Embeddable
public class VehiculeGPSTrackerPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "GPSTracker_id")
    private int gPSTrackerid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Vehicule_id")
    private int vehiculeid;

    public VehiculeGPSTrackerPK() {
    }

    public VehiculeGPSTrackerPK(int gPSTrackerid, int vehiculeid) {
        this.gPSTrackerid = gPSTrackerid;
        this.vehiculeid = vehiculeid;
    }

    public int getGPSTrackerid() {
        return gPSTrackerid;
    }

    public void setGPSTrackerid(int gPSTrackerid) {
        this.gPSTrackerid = gPSTrackerid;
    }

    public int getVehiculeid() {
        return vehiculeid;
    }

    public void setVehiculeid(int vehiculeid) {
        this.vehiculeid = vehiculeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) gPSTrackerid;
        hash += (int) vehiculeid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehiculeGPSTrackerPK)) {
            return false;
        }
        VehiculeGPSTrackerPK other = (VehiculeGPSTrackerPK) object;
        if (this.gPSTrackerid != other.gPSTrackerid) {
            return false;
        }
        if (this.vehiculeid != other.vehiculeid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.VehiculeGPSTrackerPK[ gPSTrackerid=" + gPSTrackerid + ", vehiculeid=" + vehiculeid + " ]";
    }
    
}
