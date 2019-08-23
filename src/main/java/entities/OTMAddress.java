package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OTMAddress {
    @Id
    @GeneratedValue
    private int id;

    private String street;


    @ManyToOne
    OTMPerson person;



    public OTMAddress() {
    }

    public OTMAddress(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPerson(OTMPerson person) {
        this.person = person;
    }
}