package com.udemy.backendninja.controller.service.impl;

import com.udemy.backendninja.controller.entity.Course;
import com.udemy.backendninja.controller.repository.CourseJpaRepository;
import com.udemy.backendninja.controller.service.CourseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

    private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);


    @Autowired
    @Qualifier("courseJpaRepository")
    private CourseJpaRepository courseJpaRepository;


    @Override
    public List<Course> listAllCourses() {
        LOG.info("Call: " + "listAllCourses()");
        return courseJpaRepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        LOG.info("Call: " + "addCourse()");
        return courseJpaRepository.save(course);
    }

    @Override
    public int removeCourse(int id) {
        LOG.info("Call: " + "removeCourse()");
        courseJpaRepository.deleteById(id);
        return 0;
    }

    @Override
    public Course updateCourse(Course course) {
        LOG.info("Call: " + "updateCourse()");
        return courseJpaRepository.save(course);
    }
}
