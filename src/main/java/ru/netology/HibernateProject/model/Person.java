package ru.netology.HibernateProject.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "persons")
public class Person implements Serializable {
    @EmbeddedId
    private PersonKey personKey;
    @Column(name = "phone_noumber")
    private Integer phoneNumber;
    @Column(name = "city_of_living")
    private String cityOfLiving;

    public Person() {
    }

    public Person(PersonKey personKey, Integer phoneNumber, String cityOfLiving) {
        this.personKey = personKey;
        this.phoneNumber = phoneNumber;
        this.cityOfLiving = cityOfLiving;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(personKey, person.personKey) && Objects.equals(phoneNumber, person.phoneNumber) && Objects.equals(cityOfLiving, person.cityOfLiving);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personKey, phoneNumber, cityOfLiving);
    }

    public PersonKey getPersonPrimaryCompositeKey() {
        return personKey;
    }

    public void setPersonPrimaryCompositeKey(PersonKey personKey) {
        this.personKey = personKey;
    }

    @Override
    public String toString() {
        return "name: " + personKey.getName() + +'\'' +
                ", surname: " + personKey.getSurname() + '\'' +
                ", age: " + personKey.getAge() + '\'' +
                ", phoneNumber: " + phoneNumber + '\'' +
                ", cityOfLiving='" + cityOfLiving + '\'' +
                '}';
    }

    public void setName(String name) {
        this.personKey.setName(name);
    }

    public void setSurname(String surname) {
        this.personKey.setSurname(surname);
    }

    public void setAge(int age) {
        this.personKey.setAge(age);
    }

    public void setPhoneNumber (int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCityOfLiving(String cityOfLiving) {
        this.cityOfLiving = cityOfLiving;
    }

    public PersonKey getPersonKey() {
        return personKey;
    }
}
