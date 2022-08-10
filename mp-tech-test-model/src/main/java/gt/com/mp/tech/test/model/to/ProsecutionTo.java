/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.mp.tech.test.model.to;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diego
 */
@Entity
@XmlRootElement(name = "prosecution")
public class ProsecutionTo implements Serializable {

    public ProsecutionTo() {
    }

    @Id
    private Short prosecution_id;
    private String name;
    private String location;
    private String noTel;

    @XmlElement(name = "prosecution_id")
    public Short getProsecution_id() {
        return prosecution_id;
    }

    public void setProsecution_id(Short prosecution_id) {
        this.prosecution_id = prosecution_id;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @XmlElement(name = "noTel")
    public String getNoTel() {
        return noTel;
    }

    public void setNoTel(String noTel) {
        this.noTel = noTel;
    }

    @Override
    public String toString() {
        return "prosecutionTo { prosecution_id=" + prosecution_id
                + ", name=" + name
                + ", location=" + location
                + ", number=" + noTel + '}';
    }

}
