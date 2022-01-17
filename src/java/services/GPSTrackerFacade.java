/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.GPSTracker;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author EL MAHDI
 */
@Stateless
public class GPSTrackerFacade extends AbstractFacade<GPSTracker> {

    @PersistenceContext(unitName = "Client_WebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GPSTrackerFacade() {
        super(GPSTracker.class);
    }
    
}
