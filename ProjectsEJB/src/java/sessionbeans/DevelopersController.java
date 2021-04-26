package sessionbeans;

import entities.Developers;
import sessionbeans.util.JsfUtil;
import sessionbeans.util.JsfUtil.PersistAction;

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

@Named("developersController")
@SessionScoped
public class DevelopersController implements Serializable {

    @EJB
    private sessionbeans.DevelopersFacade ejbFacade;
    private List<Developers> items = null;
    private Developers selected;

    public DevelopersController() {
    }

    public Developers getSelected() {
        return selected;
    }

    public void setSelected(Developers selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private DevelopersFacade getFacade() {
        return ejbFacade;
    }

    public Developers prepareCreate() {
        selected = new Developers();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/EJBProject").getString("DevelopersCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/EJBProject").getString("DevelopersUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/EJBProject").getString("DevelopersDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; 
            items = null;   
        }
    }

    public List<Developers> getItems() {
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
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/EJBProject").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/EJBProject").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Developers getDevelopers(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Developers> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Developers> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Developers.class)
    public static class DevelopersControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DevelopersController controller = (DevelopersController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "developersController");
            return controller.getDevelopers(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Developers) {
                Developers o = (Developers) object;
                return getStringKey(o.getDevId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Developers.class.getName()});
                return null;
            }
        }

    }

}
