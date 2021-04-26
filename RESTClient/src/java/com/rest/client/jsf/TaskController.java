
package com.rest.client.jsf;

import com.rest.client.data.Task;
import com.rest.client.data.TaskClient;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.Response;
import org.primefaces.json.JSONException;

/**
 *
 * @author John Mekubo
 */
@Named(value = "taskController")
@SessionScoped
public class TaskController implements Serializable {

    Map<Integer,Task> task = new HashMap<Integer,Task>();
    
    TaskClient client = new TaskClient();
    Task current = new Task();
    
    
    public TaskController() {
        try{
            constructTaskList(client.tasks());
        }catch(JSONException e){
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),"");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }
    }
    private void constructTaskList(String jsonListofTasks) throws JSONException{
        if (jsonListofTasks == null || jsonListofTasks.isEmpty()){
            throw new JSONException("Task List Cannot be empty or null");
        }
    }
    public void prepareCreate(){
        current = new Task();
    }
    
    public void create() {
        try{
            Response response = client.createTask(current.toJSON());
            if (response.getStatus() == Response.Status.BAD_REQUEST.getStatusCode()){
                FacesMessage faceMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bad Request", "");
                FacesContext.getCurrentInstance().addMessage(null, faceMsg);
                return;
            }
            constructTaskList(client.tasks());
        }catch(JSONException e){
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),"");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }
    }
    
    public List<Task> getTasks(){
        List<Task> list = new ArrayList(task.values());
        return list;
    }
    
}
