package com.udemy.backendninja.controller.controller;

import com.udemy.backendninja.controller.Constante;
import com.udemy.backendninja.controller.entity.Course;
import com.udemy.backendninja.controller.repository.CourseJpaRepository;
import com.udemy.backendninja.controller.service.CourseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/course")
public class CourseController {

    private static final Log LOG = LogFactory.getLog(CourseController.class);

    @Autowired
    @Qualifier("courseService")
    private CourseService courseService;

    @GetMapping("/listcourses")
    public ModelAndView listCourses(){
        LOG.info("Call: " + "listCourses()");
        ModelAndView mav = new ModelAndView(Constante.COURSES_VIEW);
        mav.addObject("course", new Course());
        mav.addObject("courses", courseService.listAllCourses());
        return mav;
    }

    @PostMapping("/addcourse")
    public String addCourse(@ModelAttribute("course") Course course){
        LOG.info("Call: " + "addCourse()" + " -- Param: " + course.toString() );
        courseService.addCourse(course);
        return "redirect:/courses/listCourses";
    }

}
