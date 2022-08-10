/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.mp.tech.test.model.db;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "prosecution_headquarter")
@XmlRootElement
public class Prosecution implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prosecution_id")
    private Short prosecutionId;

    @Basic(optional = true)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "location")
    private String location;

    @Basic(optional = false)
    @Column(name = "noTel")
    private String noTel;

    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private Date creationDate;

    @Basic(optional = true)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    private Date updateDate;

    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;

    public Prosecution() {
    }

    public Prosecution(Short prosecutionId) {
        this.prosecutionId = prosecutionId;
    }

    public Prosecution(Short prosecutionId, String name, String noTel, String location, boolean status) {
        this.prosecutionId = prosecutionId;
        this.name = name;
        this.location = location;
        this.noTel = noTel;
        this.status = status;
    }

    public Short getProsecutionId() {
        return prosecutionId;
    }

    public void setProsecutionId(Short prosecutionId) {
        this.prosecutionId = prosecutionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNoTel() {
        return noTel;
    }

    public void setNoTel(String noTel) {
        this.noTel = noTel;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.prosecutionId);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Prosecution)) {
            return false;
        }
        Prosecution other = (Prosecution) object;
        return !((this.prosecutionId == null
                && other.prosecutionId != null)
                || (this.prosecutionId != null
                && !this.prosecutionId.equals(other.prosecutionId)));
    }

    @Override
    public String toString() {
        return "gt.com.mp.tech.test.model.db.Prosecution[ prosecutionId=" + prosecutionId + " ]";
    }

}
