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

    @GetMapping("/persons/by-city")
    public String getPersonsByCity(@RequestParam("city") String city) {

        List<Person> persons = getService.getPersonsByCity(city);
        return persons.toString();
    }
}
