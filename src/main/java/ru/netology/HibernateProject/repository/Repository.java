package ru.netology.HibernateProject.repository;

import ru.netology.HibernateProject.model.Person;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;

public class Repository {
    @PersistenceContext
    private EntityManager entityManager;

    private final static String GET_PERSON_BY_CITY = "select p from Person p where p.cityOfLiving = :cityOfLiving";

    public List<Person> getPersonsByCity(String city) {
        Query query = entityManager.createQuery(GET_PERSON_BY_CITY);
        query.setParameter("cityOfLiving", city);
        List<Person> resultSet = query.getResultList();
        return resultSet;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
