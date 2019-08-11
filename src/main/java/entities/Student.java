package entities;

import enums.Days;
import org.hibernate.annotations.Type;


import javax.persistence.*;

/**
 * Created by Kor on 06.08.2019.
 */
@Entity
public class Student {
    @Id
    @GeneratedValue
    private int id;
    //@Basic(fetch = FetchType.LAZY,optional = false) //optional false создает поле name с адрибутом not null; fetch lazy ленивая инициализация
    //@Column(name = "name",unique = false,nullable = false,length = 255)
    //@Type(type = "String")
    private String name;

    //@Enumerated(EnumType.ORDINAL) // STRING в таблице именем & ORDINAL default в таблице цифрой от 0
    private Days days;

    public Student() {
            }

    public Student(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Student(String name, Days days) {
        this.name = name;
        this.days = days;
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
}
