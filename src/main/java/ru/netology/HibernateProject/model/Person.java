package ru.netology.HibernateProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "persons")
public class Person implements Serializable {
    @Id
    @Column (name = "name")
    private String name;
    @Id
    @Column (name = "surname")
    private String surname;
    @Id
    private int age;
    @Column (name = "phone_noumber")
    private Integer phoneNumber;
    @Column (name = "city_of_living")
    private String cityOfLiving;

    public Person(String name, String surname, int age, Integer phoneNumber, String cityofLiving) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.cityOfLiving = cityOfLiving;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber +
                ", cityOfLiving='" + cityOfLiving + '\'' +
                '}';
    }
}
