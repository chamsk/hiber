package entities;

import javax.persistence.*;

@Entity
public class OTOPerson {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToOne
   // @JoinColumn(name = "addrrrrrr") //аналог Column
    private OTOAddress address;

    public OTOPerson(String name, OTOAddress address) {
        this.name = name;
        this.address = address;
    }

    public OTOPerson() {
    }
}