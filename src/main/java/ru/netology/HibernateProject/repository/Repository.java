package ru.netology.HibernateProject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.HibernateProject.model.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;

public class Repository {
    @Autowired
    private PersonRepository personRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public void createPerson(Person person) {
        personRepository.save(person);
    }

    public Person getPersonByNameAndSurname (String name, String surname) {
         Person answer = personRepository.findByPersonKeyNameAndPersonKeySurname(name, surname).orElseThrow(
                 () -> new EntityNotFoundException("Person not found"));
         return answer;
    }

    //todo не удаётся изменить поля, которые входят в композитный ключ. С другими полями всё ок
    @Transactional
    public void updatePerson (String name, String surname, String whatToChange, String newValue) {
                Person person = getPersonByNameAndSurname(name, surname);
        switch (whatToChange){
            case "age":
                person.getPersonKey().setAge(Integer.parseInt(newValue));
                break;
            case "name":
                person.getPersonKey().setName(newValue);
                break;
            case "surname":
                person.getPersonKey().setSurname(newValue);
                break;
            case "phonenumber":
                person.setPhoneNumber(Integer.parseInt(newValue));
                break;
            case "cityOfLiving":
                person.setCityOfLiving(newValue);
                break;
        }
        personRepository.save(person);
    }

    @Transactional
    public void deletePerson (String name, String surname) {
        personRepository.deleteByPersonKeyNameAndPersonKeySurname(name,surname);
    }

    public List<Person> findByCityOfLiving(String city) {
        List<Person> result = personRepository.findAllByCityOfLiving(city);
        return result;
    }

    public List<Person> getAllPersonsWhereAgeSmaller (int age) {
        List<Person> result = personRepository.findByPersonKeyAgeIsLessThanOrderByPersonKeyAge(age);
        return result;
    }
}
