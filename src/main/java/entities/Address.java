package entities;

import javax.persistence.Embeddable;

@Embeddable
public class Address {                   //embeddable - встраиваемый объект(в студента)
    String string;
    int number;

    public Address() {
    }

    public Address(String string, int number) {
        this.string = string;
        this.number = number;
    }



}