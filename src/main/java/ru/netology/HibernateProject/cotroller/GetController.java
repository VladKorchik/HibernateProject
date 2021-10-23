package ru.netology.HibernateProject.cotroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.HibernateProject.model.Person;
import ru.netology.HibernateProject.service.GetService;
import java.util.List;

@RestController
public class GetController {
    GetService getService;

    public GetController(GetService getService) {
        this.getService = getService;
    }

    @GetMapping("/index")
    public String indexPage () {
        String greeting = "Hi there!";
        return greeting;
    }

    @GetMapping("/get-by-age")
    public List<Person> getByAgeWhereAgeSmallerThan(@RequestParam("age") int age) {
        List<Person> result = getService.getByAgeWhereAgeSmallerThan(age);
        return result;
    }

    @GetMapping("/get-by-city")
    public List<Person> getByCity(@RequestParam("city") String city) {
        List<Person> result = getService.getByCity(city);
        return result;
    }

    @GetMapping("/createPerson")
    public String addPerson(@RequestParam("name") String name, @RequestParam ("surname") String surname,
    @RequestParam ("age") int age, @RequestParam ("phonenumber") Integer phoneNumber,
                            @RequestParam ("city") String city ){
        getService.createPerson (name,surname,age,phoneNumber,city);
        String answer = "done";
        return answer;
    }

    @GetMapping ("/getPersonByNameAndSurname")
    public String  getPersonByNameAndSurname(@RequestParam("name") String name,
                                             @RequestParam("surname") String surname) {
        Person person = getService.getPersonByNameAndSurname(name,surname);
        return person.toString();
    }

    @GetMapping("/delete-person")
    public String deletePerson (@RequestParam("name") String name, @RequestParam("surname") String surname) {
        getService.deletePerson(name, surname);
        return new String("done");
    }

    @GetMapping("/update-person")
    public String updatePerson (@RequestParam("name") String name, @RequestParam("surname") String surname,
                              @RequestParam ("whattochange") String whatToChange,
                              @RequestParam ("newvalue") String newValue ) {
        getService.updatePerson(name, surname, whatToChange, newValue);
        return new String("done");
    }

}
