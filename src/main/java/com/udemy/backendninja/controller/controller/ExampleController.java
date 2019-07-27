package com.udemy.backendninja.controller.controller;

import com.udemy.backendninja.controller.Constante;
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
        model.addAttribute("name", "Sebastian");
        return Constante.EXAMPLE_HTML;
    }

    @GetMapping("/exampleMAV")
    public ModelAndView obtenerPaginaExampleMAV(){
        ModelAndView mav = new ModelAndView(Constante.EXAMPLE_HTML);
        mav.addObject("name", "MikeMAV");
        return mav;
    }
}
