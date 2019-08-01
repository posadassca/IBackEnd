package com.udemy.backendninja.controller.controller;

import com.udemy.backendninja.controller.Constante;
import com.udemy.backendninja.controller.service.EjercicioService;
import com.udemy.backendninja.controller.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/ejercicio")
public class EjercicioController {

    @Autowired
    @Qualifier("ejercicioService")
    private EjercicioService ejercicioService;

    @GetMapping("/show")
    public RedirectView redirect() {
        ejercicioService.mostrarLog();
        return new RedirectView("/ejercicio/path02");
    }

    @GetMapping("/path02")
    public ModelAndView segundoPath() {
        ModelAndView mav = new ModelAndView(Constante.RESULTEJERCICIO);
        mav.addObject("mensaje", ejercicioService.mensaje());
        return mav;
    }
}
