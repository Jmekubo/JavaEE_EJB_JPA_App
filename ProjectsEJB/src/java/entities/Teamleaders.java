
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
@Table(name = "teamleaders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teamleaders.findAll", query = "SELECT t FROM Teamleaders t")
    , @NamedQuery(name = "Teamleaders.findByTemId", query = "SELECT t FROM Teamleaders t WHERE t.temId = :temId")
    , @NamedQuery(name = "Teamleaders.findByFirstname", query = "SELECT t FROM Teamleaders t WHERE t.firstname = :firstname")
    , @NamedQuery(name = "Teamleaders.findByLastname", query = "SELECT t FROM Teamleaders t WHERE t.lastname = :lastname")
    , @NamedQuery(name = "Teamleaders.findByPhone", query = "SELECT t FROM Teamleaders t WHERE t.phone = :phone")
    , @NamedQuery(name = "Teamleaders.findByLocId", query = "SELECT t FROM Teamleaders t WHERE t.locId = :locId")
    , @NamedQuery(name = "Teamleaders.findByUserId", query = "SELECT t FROM Teamleaders t WHERE t.userId = :userId")})
public class Teamleaders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "temId")
    private Integer temId;
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
    @Size(max = 45)
    @Column(name = "phone")
    private String phone;
    @Column(name = "locId")
    private Integer locId;
    @Column(name = "userId")
    private Integer userId;

    public Teamleaders() {
    }

    public Teamleaders(Integer temId) {
        this.temId = temId;
    }

    public Teamleaders(Integer temId, String firstname, String lastname) {
        this.temId = temId;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Integer getTemId() {
        return temId;
    }

    public void setTemId(Integer temId) {
        this.temId = temId;
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
        hash += (temId != null ? temId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Teamleaders)) {
            return false;
        }
        Teamleaders other = (Teamleaders) object;
        if ((this.temId == null && other.temId != null) || (this.temId != null && !this.temId.equals(other.temId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Teamleaders[ temId=" + temId + " ]";
    }
    
}
