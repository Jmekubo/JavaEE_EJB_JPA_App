package sessionbeans;

import entities.Teamleaders;
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

@Named("teamleadersController")
@SessionScoped
public class TeamleadersController implements Serializable {

    @EJB
    private sessionbeans.TeamleadersFacade ejbFacade;
    private List<Teamleaders> items = null;
    private Teamleaders selected;

    public TeamleadersController() {
    }

    public Teamleaders getSelected() {
        return selected;
    }

    public void setSelected(Teamleaders selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TeamleadersFacade getFacade() {
        return ejbFacade;
    }

    public Teamleaders prepareCreate() {
        selected = new Teamleaders();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/EJBProject").getString("TeamleadersCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;   
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/EJBProject").getString("TeamleadersUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/EJBProject").getString("TeamleadersDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; 
            items = null;   
        }
    }

    public List<Teamleaders> getItems() {
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

    public Teamleaders getTeamleaders(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Teamleaders> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Teamleaders> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Teamleaders.class)
    public static class TeamleadersControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TeamleadersController controller = (TeamleadersController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "teamleadersController");
            return controller.getTeamleaders(getKey(value));
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
            if (object instanceof Teamleaders) {
                Teamleaders o = (Teamleaders) object;
                return getStringKey(o.getTemId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Teamleaders.class.getName()});
                return null;
            }
        }

    }

}
