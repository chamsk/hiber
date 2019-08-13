package entities;

import enums.Days;
import org.hibernate.annotations.*;



import javax.persistence.*;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Kor on 06.08.2019.
 */
@Entity
//@Table(name = "AnotherNameTable")
public class Student {
    @Id
    @GeneratedValue
    //@GeneratedValue(strategy = GenerationType.IDENTITY) бывают разные стратегии генерации ID
    private int id;

    //@Basic(fetch = FetchType.LAZY,optional = false) //optional false создает поле name с адрибутом not null; fetch lazy ленивая инициализация
    @Column(name = "name",unique = false,nullable = false,length = 255)
    //@Type(type = "String")
    private String name;

    @Enumerated(EnumType.STRING) // STRING в таблице именем & ORDINAL default в таблице цифрой от 0
    private Days days;

    @Temporal(TemporalType.DATE)//date - только дата, time - только время, timestamp - время и дата
    //@CreationTimestamp генерация даты создания
    //@UpdateTimestamp генерация даты обновления
    private Date date;

//    @Formula("id + age")      вернет сумму
//    private int idPlusAge;

//    @Access(AccessType.FIELD) устанавливается над полем. говорит хиберу читать напрямую из поля
//    Если же будет PROPERTY, то будет читать из getter'a.
//    Можно пометить геттеры аннотацией @Id & @GeneratedValue для того, чтоб все поля читались из геттеров

//    @Transient устанавливается над полем, которое при занесении в базу нужно игнорировать

    private Address address;

    public Student() {
            }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, Days days) {
        this.name = name;
        this.days = days;
    }

    public Student(String name, Days days, Date date) {
        this.name = name;
        this.days = days;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Days getDays() {
        return days;
    }

    public void setDays(Days days) {
        this.days = days;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
