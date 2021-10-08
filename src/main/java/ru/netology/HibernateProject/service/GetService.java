package ru.netology.HibernateProject.service;

import ru.netology.HibernateProject.model.Person;
import ru.netology.HibernateProject.repository.Repository;

import java.util.List;

public class GetService {
    Repository repository;

    public GetService(Repository repository) {
        this.repository = repository;
    }

    public List<Person> getPersonsByCity (String city) {
        List<Person> result = repository.getPersonsByCity(city);

        return result;
    }

}
