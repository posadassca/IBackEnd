package com.udemy.backendninja.controller.controller;

import com.udemy.backendninja.controller.Constante;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/example02")
public class Example02Controller {

    //localhost:8080/example02/request01?nm=Sebastian
    //localhost:8080/example02/request01?nm=John
    @GetMapping("/request01")
    public ModelAndView request01(@RequestParam(name="nm", required = false, defaultValue = "NULL") String name){
        ModelAndView mav = new ModelAndView(Constante.EXAMPLE02_HTML);
        mav.addObject("nm_in_model", name);
        return mav;
    }

    //localhost:8080/example02/request02/John
    //localhost:8080/example02/request02/Mikel
    @GetMapping("/request02/{nm}")
    public ModelAndView request02(@PathVariable("nm") String name){
        ModelAndView mav = new ModelAndView(Constante.EXAMPLE02_HTML);
        mav.addObject("nm_in_model", name);
        return mav;
    }
}
