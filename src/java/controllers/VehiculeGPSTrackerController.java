package controllers;

import entities.VehiculeGPSTracker;
import controllers.util.JsfUtil;
import controllers.util.JsfUtil.PersistAction;
import services.VehiculeGPSTrackerFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("vehiculeGPSTrackerController")
@SessionScoped
public class VehiculeGPSTrackerController implements Serializable {

    @EJB
    private services.VehiculeGPSTrackerFacade ejbFacade;
    private List<VehiculeGPSTracker> items = null;
    private VehiculeGPSTracker selected;

    public VehiculeGPSTrackerController() {
    }

    public VehiculeGPSTracker getSelected() {
        return selected;
    }

    public void setSelected(VehiculeGPSTracker selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getVehiculeGPSTrackerPK().setVehiculeid(selected.getVehicule().getId());
        selected.getVehiculeGPSTrackerPK().setGPSTrackerid(selected.getGPSTracker().getId());
    }

    protected void initializeEmbeddableKey() {
        selected.setVehiculeGPSTrackerPK(new entities.VehiculeGPSTrackerPK());
    }

    private VehiculeGPSTrackerFacade getFacade() {
        return ejbFacade;
    }

    public VehiculeGPSTracker prepareCreate() {
        selected = new VehiculeGPSTracker();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("VehiculeGPSTrackerCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("VehiculeGPSTrackerUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("VehiculeGPSTrackerDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<VehiculeGPSTracker> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public VehiculeGPSTracker getVehiculeGPSTracker(entities.VehiculeGPSTrackerPK id) {
        return getFacade().find(id);
    }

    public List<VehiculeGPSTracker> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<VehiculeGPSTracker> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = VehiculeGPSTracker.class)
    public static class VehiculeGPSTrackerControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            VehiculeGPSTrackerController controller = (VehiculeGPSTrackerController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "vehiculeGPSTrackerController");
            return controller.getVehiculeGPSTracker(getKey(value));
        }

        entities.VehiculeGPSTrackerPK getKey(String value) {
            entities.VehiculeGPSTrackerPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new entities.VehiculeGPSTrackerPK();
            key.setGPSTrackerid(Integer.parseInt(values[0]));
            key.setVehiculeid(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(entities.VehiculeGPSTrackerPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getGPSTrackerid());
            sb.append(SEPARATOR);
            sb.append(value.getVehiculeid());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof VehiculeGPSTracker) {
                VehiculeGPSTracker o = (VehiculeGPSTracker) object;
                return getStringKey(o.getVehiculeGPSTrackerPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), VehiculeGPSTracker.class.getName()});
                return null;
            }
        }

    }

}
