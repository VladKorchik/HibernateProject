package ru.netology.HibernateProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.netology.HibernateProject.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, String > {

    List<Person> findByPersonKeyAgeIsLessThanOrderByPersonKeyAge (int age);

    List<Person> findAllByCityOfLiving(String city);

    Optional<Person> findByPersonKeyNameAndPersonKeySurname (String name, String surname);

    void deleteByPersonKeyNameAndPersonKeySurname (String name, String surname);

//    @Query(value = "update persons set whatToChange = newValue where name=name and surname=surname", nativeQuery = true)
//    void updatePerson (@Param("whatToChange") String whatToChange, @Param("newValue")String newValue,
//                       @Param("name") String name, @Param("surname") String surname);

}
