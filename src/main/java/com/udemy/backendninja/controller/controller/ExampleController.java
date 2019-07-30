package com.udemy.backendninja.controller.controller;

import com.udemy.backendninja.controller.Constante;
import com.udemy.backendninja.controller.component.ExampleComponent;
import com.udemy.backendninja.controller.model.Person;
import com.udemy.backendninja.controller.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    private final ExampleComponent exampleComponent;

    @Autowired
    public ExampleController(@Qualifier("exampleComponent") ExampleComponent exampleComponent) {
        this.exampleComponent = exampleComponent;
    }

    @Autowired
    @Qualifier("exampleService")
    private ExampleService exampleService;

    @GetMapping("/exampleString")
    public String obtenerPaginaExampleC(Model model){
        exampleComponent.sayHello();
        model.addAttribute("people", exampleService.getListPeople());
        return Constante.EXAMPLE_HTML;
    }

    @GetMapping("/exampleMAV")
    public ModelAndView obtenerPaginaExampleMAV(){
        ModelAndView mav = new ModelAndView(Constante.EXAMPLE_HTML);
        mav.addObject("people", exampleService.getListPeople());
        return mav;
    }

}
