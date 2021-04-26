
package com.rest.client.data;

import com.pms.entities.Projects;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;


/**
 *
 * @author John Mekubo
 */
@Entity
@Table(name = "tasks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tasks.findAll", query = "SELECT t FROM Tasks t")
    , @NamedQuery(name = "Tasks.findByTaskId", query = "SELECT t FROM Tasks t WHERE t.taskId = :taskId")
    , @NamedQuery(name = "Tasks.findByTaskdetails", query = "SELECT t FROM Tasks t WHERE t.taskdetails = :taskdetails")
    , @NamedQuery(name = "Tasks.findByStartdate", query = "SELECT t FROM Tasks t WHERE t.startdate = :startdate")
    , @NamedQuery(name = "Tasks.findByEnddate", query = "SELECT t FROM Tasks t WHERE t.enddate = :enddate")
    , @NamedQuery(name = "Tasks.findByStatus", query = "SELECT t FROM Tasks t WHERE t.status = :status")})
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "taskId")
    private Integer taskId;
    @Basic(optional = false)
    @Column(name = "taskdetails")
    private String taskdetails;
    @Basic(optional = false)
    @Column(name = "startdate")
    @Temporal(TemporalType.DATE)
    private String startdate;
    @Basic(optional = false)
    @Column(name = "enddate")
    @Temporal(TemporalType.DATE)
    private String enddate;
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "projId", referencedColumnName = "projId")
    @ManyToOne
    private Projects projId;
    
    public static final String ID_KEY = "taskId";
    public static final String TASKDETAILS_KEY = "taskdetails";
    public static final String STARTDATE_KEY = "startdate";
    public static final String ENDDATE_KEY = "enddate";
    public static final String STATUS_KEY = "status";

    public Task() {
    }
    
    

    public Task(Integer taskId) {
        this.taskId = taskId;
    }

   

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskdetails() {
        return taskdetails;
    }

    public void setTaskdetails(String taskdetails) {
        this.taskdetails = taskdetails;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Projects getProjId() {
        return projId;
    }

    public void setProjId(Projects projId) {
        this.projId = projId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskId != null ? taskId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.taskId == null && other.taskId != null) || (this.taskId != null && !this.taskId.equals(other.taskId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.taskdetails;
    }
    
    public String toJSON() throws JSONException{
        JSONObject obj = new JSONObject();
        obj.put(ID_KEY, this.taskId);
        obj.put(TASKDETAILS_KEY, this.taskdetails);
        SimpleDateFormat format = new SimpleDateFormat(STARTDATE_KEY);
        String startdateString = format.format(this.startdate);
        obj.put(STARTDATE_KEY,startdateString);
        SimpleDateFormat format2 = new SimpleDateFormat(ENDDATE_KEY);
        String enddateString = format2.format(this.enddate);
        obj.put(ENDDATE_KEY,enddateString);
        obj.put(STATUS_KEY, this.status);
        return obj.toString();
    }
    
     public JSONObject toJSONObject() throws JSONException{
        JSONObject obj = new JSONObject();
        obj.put(ID_KEY, taskId);
        obj.put(TASKDETAILS_KEY, taskdetails);
        SimpleDateFormat format = new SimpleDateFormat(STARTDATE_KEY);
        String startdateString = format.format(startdate);
        obj.put(STARTDATE_KEY,startdateString);
        SimpleDateFormat format2 = new SimpleDateFormat(ENDDATE_KEY);
        String enddateString = format2.format(enddate);
        obj.put(ENDDATE_KEY,enddateString);
        obj.put(STATUS_KEY, status);
        return obj;
    }
}
