
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author John Mekubo
 */
@Entity
@Table(name = "projectmanagers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Projectmanagers.findAll", query = "SELECT p FROM Projectmanagers p")
    , @NamedQuery(name = "Projectmanagers.findByPmId", query = "SELECT p FROM Projectmanagers p WHERE p.pmId = :pmId")
    , @NamedQuery(name = "Projectmanagers.findByFirstname", query = "SELECT p FROM Projectmanagers p WHERE p.firstname = :firstname")
    , @NamedQuery(name = "Projectmanagers.findByLastname", query = "SELECT p FROM Projectmanagers p WHERE p.lastname = :lastname")
    , @NamedQuery(name = "Projectmanagers.findByPhone", query = "SELECT p FROM Projectmanagers p WHERE p.phone = :phone")
    , @NamedQuery(name = "Projectmanagers.findByLocId", query = "SELECT p FROM Projectmanagers p WHERE p.locId = :locId")
    , @NamedQuery(name = "Projectmanagers.findByUserId", query = "SELECT p FROM Projectmanagers p WHERE p.userId = :userId")})
public class Projectmanagers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pmId")
    private Integer pmId;
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

    public Projectmanagers() {
    }

    public Projectmanagers(Integer pmId) {
        this.pmId = pmId;
    }

    public Projectmanagers(Integer pmId, String firstname, String lastname, String phone) {
        this.pmId = pmId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
    }

    public Integer getPmId() {
        return pmId;
    }

    public void setPmId(Integer pmId) {
        this.pmId = pmId;
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
        hash += (pmId != null ? pmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Projectmanagers)) {
            return false;
        }
        Projectmanagers other = (Projectmanagers) object;
        if ((this.pmId == null && other.pmId != null) || (this.pmId != null && !this.pmId.equals(other.pmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Projectmanagers[ pmId=" + pmId + " ]";
    }
    
}
