
package entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author John Mekubo
 */
@Entity
@Table(name = "projects")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Projects.findAll", query = "SELECT p FROM Projects p")
    , @NamedQuery(name = "Projects.findByProjId", query = "SELECT p FROM Projects p WHERE p.projId = :projId")
    , @NamedQuery(name = "Projects.findByProjectdetails", query = "SELECT p FROM Projects p WHERE p.projectdetails = :projectdetails")
    , @NamedQuery(name = "Projects.findByStartdate", query = "SELECT p FROM Projects p WHERE p.startdate = :startdate")
    , @NamedQuery(name = "Projects.findByEnddate", query = "SELECT p FROM Projects p WHERE p.enddate = :enddate")
    , @NamedQuery(name = "Projects.findByTemId", query = "SELECT p FROM Projects p WHERE p.temId = :temId")
    , @NamedQuery(name = "Projects.findByPmId", query = "SELECT p FROM Projects p WHERE p.pmId = :pmId")})
public class Projects implements Serializable {

   
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "projId")
    private Integer projId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "projectdetails")
    private String projectdetails;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startdate")
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enddate")
    @Temporal(TemporalType.DATE)
    private Date enddate;
    @Column(name = "temId")
    private Integer temId;
    @Column(name = "pmId")
    private Integer pmId;
    @JoinColumn(name = "custId", referencedColumnName = "custId")
    @ManyToOne
    private Customers custId;
    @OneToMany(mappedBy = "projId")
    private Collection<Tasks> tasksCollection;

    public Projects() {
    }

    public Projects(Integer projId) {
        this.projId = projId;
    }

    public Projects(Integer projId, String projectdetails, Date startdate, Date enddate) {
        this.projId = projId;
        this.projectdetails = projectdetails;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public Integer getProjId() {
        return projId;
    }

    public void setProjId(Integer projId) {
        this.projId = projId;
    }

    public String getProjectdetails() {
        return projectdetails;
    }

    public void setProjectdetails(String projectdetails) {
        this.projectdetails = projectdetails;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Integer getTemId() {
        return temId;
    }

    public void setTemId(Integer temId) {
        this.temId = temId;
    }

    public Integer getPmId() {
        return pmId;
    }

    public void setPmId(Integer pmId) {
        this.pmId = pmId;
    }

    public Customers getCustId() {
        return custId;
    }

    public void setCustId(Customers custId) {
        this.custId = custId;
    }

    @XmlTransient
    public Collection<Tasks> getTasksCollection() {
        return tasksCollection;
    }

    public void setTasksCollection(Collection<Tasks> tasksCollection) {
        this.tasksCollection = tasksCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projId != null ? projId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Projects)) {
            return false;
        }
        Projects other = (Projects) object;
        if ((this.projId == null && other.projId != null) || (this.projId != null && !this.projId.equals(other.projId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Projects[ projId=" + projId + " ]";
    }
    
}
