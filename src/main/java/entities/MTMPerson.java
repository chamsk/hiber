package entities;

import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.List;

@Entity
@javax.persistence.Table(name = "mtmPerson")
public class MTMPerson {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "mtmName")
    private String name;

    @Column(name = "mtmAge")
    private int age;

    @ManyToMany(mappedBy = "person")
    private List<MTMAddress> list;

    public MTMPerson() {
    }


    public MTMPerson(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public List<MTMAddress> getList() {
        return list;
    }

    public void setList(List<MTMAddress> list) {
        this.list = list;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}