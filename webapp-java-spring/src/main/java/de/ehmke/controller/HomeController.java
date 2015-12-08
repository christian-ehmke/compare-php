package de.ehmke.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController
{
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model)
    {
        String wert = "Der Wert";
        model.addAttribute("wert", wert);

        return "home/index";
    }
}
