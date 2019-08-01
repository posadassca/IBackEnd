package com.udemy.backendninja.controller.service.impl;

import com.udemy.backendninja.controller.entity.Course;
import com.udemy.backendninja.controller.repository.CourseJpaRepository;
import com.udemy.backendninja.controller.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Autowired
    @Qualifier("courseJpaRepository")
    private CourseJpaRepository courseJpaRepository;


    @Override
    public List<Course> listAllCourses() {
        return courseJpaRepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        return courseJpaRepository.save(course);
    }

    @Override
    public int removeCourse(int id) {
        courseJpaRepository.deleteById(id);
        return 0;
    }

    @Override
    public Course updateCourse(Course course) {
        return courseJpaRepository.save(course);
    }
}
