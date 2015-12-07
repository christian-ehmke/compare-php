package de.ehmke.controller;

import de.ehmke.entity.Person;
import de.ehmke.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController
{
    @Autowired
    public PersonRepository personRepository;

    @RequestMapping("/")
    public String index(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model)
    {
        model.addAttribute("name", name);

        List<Person> persons = personRepository.findAllWithAppointments();

        return "home/index";
    }
}
