package com.udemy.backendninja.controller.controller;

import com.udemy.backendninja.controller.Constante;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example04")
public class Example04Controller {

    @GetMapping("/error404")
    public String obtenerPaginaError(){
        return Constante.EXAMPLE04_ERROR;
    }

    @GetMapping("/status500")
    public String obtenerPaginaStatus(){
        return Constante.EXAMPLE04_STATUS;
    }
}
