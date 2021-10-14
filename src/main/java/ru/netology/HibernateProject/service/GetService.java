package ru.netology.HibernateProject.service;

import ru.netology.HibernateProject.model.Person;
import ru.netology.HibernateProject.model.PersonKey;
import ru.netology.HibernateProject.repository.Repository;

import java.util.List;

public class GetService {
    Repository repository;

    public GetService(Repository repository) {
        this.repository = repository;
    }

    public List<Person> getByAgeWhereAgeSmallerThan(int age) {
        List<Person> result = repository.getAllPersonsWhereAgeSmaller(age);
        return result;
    }

    public List<Person> getByCity(String city) {
        List<Person> result = repository.findByCityOfLiving(city);
        return result;
    }

    public void createPerson(String name, String surname, int age, Integer phoneNumber, String city) {
        PersonKey personKey = new PersonKey(name, surname, age);
        Person newPerson = new Person(personKey, phoneNumber, city);
        repository.createPerson(newPerson);
    }

    public Person getPersonByNameAndSurname(String name, String surname) {
        Person person = repository.getPersonByNameAndSurname(name, surname);
        return person;
    }

    public void deletePerson(String name, String surname) {
        repository.deletePerson(name, surname);
    }

    public void updatePerson(String name, String surname, String whatToChange, String newValue) {
        repository.updatePerson(name, surname, whatToChange, newValue);
    }

}
