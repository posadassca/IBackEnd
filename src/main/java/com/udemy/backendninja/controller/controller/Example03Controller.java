package com.udemy.backendninja.controller.controller;

import com.udemy.backendninja.controller.Constante;
import com.udemy.backendninja.controller.model.Person;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@RequestMapping("/example03")
public class Example03Controller {

    private static final Log LOGGER = LogFactory.getLog(Example03Controller.class);

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
//        LOGGER.info("INFO TRACE");
//        LOGGER.warn("WARNING TRACE");
//        LOGGER.error("ERROR TRACE");
//        LOGGER.debug("DEBUG TRACE");
        model.addAttribute("person", new Person());
//        Exception RuntimeException
//        int number = 6 / 0;
        return Constante.FORM_VIEW;
    }

    @PostMapping("/addperson")
    public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult){
        ModelAndView mav = new ModelAndView();
        if(bindingResult.hasErrors()){
            mav.setViewName(Constante.FORM_VIEW);
        } else {
            mav.setViewName(Constante.RESULT_VIEW);
            mav.addObject("person", person);
        }
        return mav;
    }
}
