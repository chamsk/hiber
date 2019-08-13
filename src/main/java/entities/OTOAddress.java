package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class OTOAddress {

    @Id
    @GeneratedValue
    private int id;

    private String street;

    public OTOAddress(String street) {
        this.street = street;
    }


    public OTOAddress() {
    }
}