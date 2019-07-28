package com.udemy.backendninja.controller.controller;

import com.udemy.backendninja.controller.Constante;
import com.udemy.backendninja.controller.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/example")
public class ExampleController {

    @GetMapping("/exampleString")
    public String obtenerPaginaExampleC(Model model){
        model.addAttribute("people", getPeople());
        return Constante.EXAMPLE_HTML;
    }

    @GetMapping("/exampleMAV")
    public ModelAndView obtenerPaginaExampleMAV(){
        ModelAndView mav = new ModelAndView(Constante.EXAMPLE_HTML);
        mav.addObject("people", getPeople());
        return mav;
    }

    private List<Person> getPeople() {
        List<Person> people = new ArrayList<Person>();
        people.add(new Person("Simon", 0));
        people.add(new Person("Cristian", 15));
        people.add(new Person("Sebastian", 24));
        people.add(new Person("Andres", 19));
        people.add(new Person("Carolina", 28));

        return people;
    }


}
