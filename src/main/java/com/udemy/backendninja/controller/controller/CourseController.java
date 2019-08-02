package com.udemy.backendninja.controller.controller;

import com.udemy.backendninja.controller.Constante;
import com.udemy.backendninja.controller.entity.Course;
import com.udemy.backendninja.controller.model.CourseModel;
import com.udemy.backendninja.controller.repository.CourseJpaRepository;
import com.udemy.backendninja.controller.service.CourseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/course")
public class CourseController {

    private static final Log LOG = LogFactory.getLog(CourseController.class);

    @Autowired
    @Qualifier("courseService")
    private CourseService courseService;

    @GetMapping("/")
    public RedirectView redirectView(){
        return new RedirectView("/course/listcourses");
    }

    @GetMapping("/listcourses")
    public ModelAndView listCourses(){
        LOG.info("Call: " + "listCourses()");
        ModelAndView mav = new ModelAndView(Constante.COURSES_VIEW);
        mav.addObject("course", new CourseModel());
        mav.addObject("courses", courseService.listAllCourses());
        return mav;
    }

    @PostMapping("/addcourse")
    public String addCourse(@ModelAttribute("course") CourseModel course){
        LOG.info("Call: " + "addCourse()" + " -- Param: " + course.toString() );
        courseService.addCourse(course);
        return Constante.COURSES;
    }

    @PostMapping("/removecourse")
    public String removeCourse(@ModelAttribute("id") int idCourse){
        LOG.info("Call: " + "removeCourse(" + idCourse + ") ");
        courseService.removeCourse(idCourse);
        return Constante.COURSES;
    }

    @PostMapping("/updatecourse")
    public String updateCourse(@ModelAttribute("course") CourseModel courseModel){
        LOG.info("Call: " + "updateCourse()" + "-- Param: " + courseModel.toString());
        courseService.updateCourse(courseModel);
        return Constante.COURSES;
    }

}
