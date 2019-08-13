package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class OTMPerson {
    @Id
    @GeneratedValue
    private int id;

    private String name;


    @OneToMany

    List<OTMAddress> addresses;

    public OTMPerson() {}

    public OTMPerson(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddresses(List<OTMAddress> addresses) {
        this.addresses = addresses;
    }

}