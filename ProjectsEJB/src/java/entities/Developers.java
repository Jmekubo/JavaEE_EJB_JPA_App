
package entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author John Mekubo
 */
@Entity
@Table(name = "developers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Developers.findAll", query = "SELECT d FROM Developers d")
    , @NamedQuery(name = "Developers.findByDevId", query = "SELECT d FROM Developers d WHERE d.devId = :devId")
    , @NamedQuery(name = "Developers.findByFirstname", query = "SELECT d FROM Developers d WHERE d.firstname = :firstname")
    , @NamedQuery(name = "Developers.findByLastname", query = "SELECT d FROM Developers d WHERE d.lastname = :lastname")
    , @NamedQuery(name = "Developers.findByPhone", query = "SELECT d FROM Developers d WHERE d.phone = :phone")
    , @NamedQuery(name = "Developers.findByLocId", query = "SELECT d FROM Developers d WHERE d.locId = :locId")
    , @NamedQuery(name = "Developers.findByUserId", query = "SELECT d FROM Developers d WHERE d.userId = :userId")})
public class Developers implements Serializable {
    
   

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "devId")
    private Integer devId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lastname")
    private String lastname;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "phone")
    private String phone;
    @Column(name = "locId")
    private Integer locId;
    @Column(name = "userId")
    private Integer userId;
    
  

    public Developers() {
    }

    public Developers(Integer devId) {
        this.devId = devId;
    }

    public Developers(Integer devId, String firstname, String lastname, String phone) {
        this.devId = devId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
    }

    public Integer getDevId() {
        return devId;
    }

    public void setDevId(Integer devId) {
        this.devId = devId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getLocId() {
        return locId;
    }

    public void setLocId(Integer locId) {
        this.locId = locId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (devId != null ? devId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Developers)) {
            return false;
        }
        Developers other = (Developers) object;
        if ((this.devId == null && other.devId != null) || (this.devId != null && !this.devId.equals(other.devId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Developers[ devId=" + devId + " ]";
    }
    
}
