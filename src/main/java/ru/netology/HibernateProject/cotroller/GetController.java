package ru.netology.HibernateProject.cotroller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @Secured("ROLE_READ")
    public List<Person> getByAgeWhereAgeSmallerThan(@RequestParam("age") int age) {
        List<Person> result = getService.getByAgeWhereAgeSmallerThan(age);
        return result;
    }

    @GetMapping("/get-by-city")
    @Secured("ROLE_READ")
    public List<Person> getByCity(@RequestParam("city") String city) {
        List<Person> result = getService.getByCity(city);
        return result;
    }

    @GetMapping("/createPerson")
    @Secured({"ROLE_READ", "ROLE_WRITE"})
    public String addPerson(@RequestParam("name") String name, @RequestParam ("surname") String surname,
    @RequestParam ("age") int age, @RequestParam ("phonenumber") Integer phoneNumber,
                            @RequestParam ("city") String city ){
        getService.createPerson (name,surname,age,phoneNumber,city);
        String answer = "done";
        return answer;
    }

    @GetMapping ("/getPersonByNameAndSurname")
    @PreAuthorize("#username.equals('personsGetter')")
    public String  getPersonByNameAndSurname(@RequestParam("username") String username,
                                             @RequestParam("surname") String surname) {
        Person person = getService.getPersonByNameAndSurname(username,surname);
        return person.toString();
    }

    @GetMapping("/delete-person")
    @PreAuthorize("hasRole('ROLE_DELETE') or hasRole(ROLE_WRITE)")
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
