package com.udemy.backendninja.controller.controller;

import com.udemy.backendninja.controller.Constante;
import com.udemy.backendninja.controller.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/example03")
public class Example03Controller {

    /* Primera forma
    @GetMapping("/")
    public String redirect(){
        return "redirect:/example03/showForm";
    }*/

    // Segunda Forma
    @GetMapping("/")
    public RedirectView redirect(){
        return new RedirectView("/example03/showForm");
    }

    @GetMapping("/showForm")
    public String showForm(Model model){
        model.addAttribute("person", new Person());
        return Constante.FORM_VIEW;
    }

    @PostMapping("/addperson")
    public ModelAndView addPerson(@ModelAttribute("person") Person person){
        ModelAndView mav = new ModelAndView(Constante.RESULT_VIEW);
        mav.addObject("person", person);
        return mav;
    }
}
