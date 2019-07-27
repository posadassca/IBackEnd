package com.udemy.backendninja.controller.controller;

import com.udemy.backendninja.controller.Constante;
import com.udemy.backendninja.controller.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/example")
public class ExampleController {

    @GetMapping("/exampleString")
    public String obtenerPaginaExampleC(Model model){
        model.addAttribute("person", new Person("Sebastian", 24));
        return Constante.EXAMPLE_HTML;
    }

    @GetMapping("/exampleMAV")
    public ModelAndView obtenerPaginaExampleMAV(){
        ModelAndView mav = new ModelAndView(Constante.EXAMPLE_HTML);
        mav.addObject("person", new Person("MikeMAV", 30));
        return mav;
    }
}
