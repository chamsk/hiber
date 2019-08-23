package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mtmAddress")
public class MTMAddress {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "mtmStreet")
    private String street;

    @Column(name = "mtmHouse")
    private int house;

    @ManyToMany
    @JoinTable(name = "joinTab",joinColumns = @JoinColumn(name = "addrId"),inverseJoinColumns = @JoinColumn(name = "personId"))
    List<MTMPerson> person;

    public MTMAddress() {
    }

    public MTMAddress(int house, String street) {
        this.house = house;
        this.street = street;
    }


    public List<MTMPerson> getPerson() {
        return person;
    }

    public void setPerson(List<MTMPerson> person) {
        this.person = person;
    }
}