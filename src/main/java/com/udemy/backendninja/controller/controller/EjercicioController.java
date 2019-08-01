package com.udemy.backendninja.controller.controller;

import com.udemy.backendninja.controller.Constante;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/ejercicio")
public class EjercicioController {

    
    @GetMapping("/path01")
    public RedirectView redirect(){
        return new RedirectView("/ejercicio/path02");
    }

//    @GetMapping("/path01")
//    public String primerPath(){
//        return Constante.PATH01;
//    }

    @GetMapping("/path02")
    public String segundoPath(){
        return Constante.PATH02;
    }
}
