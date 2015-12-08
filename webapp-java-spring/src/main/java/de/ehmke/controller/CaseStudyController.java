package de.ehmke.controller;

import de.ehmke.entity.Person;
import de.ehmke.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CaseStudyController
{
    @Autowired
    public PersonRepository personRepository;

    @RequestMapping(value = "/calendar", method = RequestMethod.GET)
    public String calendar(Model model)
    {
        List<Person> persons = personRepository.findAllWithAppointments();
        model.addAttribute("persons", persons);
        return "casestudy/calendar";
    }

}
