package entities;

import javax.persistence.*;

@Entity
public class OTOPerson {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToOne
    //атрибуты OneToOne cascadeType.Remove удаляет запись в адресе, если будет удален персон
    //cascadeType.PERSIST позволяет сохранять объекты отдельно друг от друга(address & person)
    //orphanRemoval удаляет сирот(без каскада(связи))
    //mappedBy = "person" делает таблицу person хозяином, если связь между таблицами бидирекшн. Тогда вторичный ключ исключается из хозяина
   // @JoinColumn(name = "addrrrrrr") //аналог Column
    private OTOAddress address;

    public OTOPerson(String name, OTOAddress address) {
        this.name = name;
        this.address = address;
    }

    public OTOPerson() {
    }
}