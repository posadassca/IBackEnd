package com.udemy.backendninja.controller.service.impl;

import com.udemy.backendninja.controller.converter.CourseConverter;
import com.udemy.backendninja.controller.entity.Course;
import com.udemy.backendninja.controller.model.CourseModel;
import com.udemy.backendninja.controller.repository.CourseJpaRepository;
import com.udemy.backendninja.controller.service.CourseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

    private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);


    @Autowired
    @Qualifier("courseJpaRepository")
    private CourseJpaRepository courseJpaRepository;

    @Autowired
    @Qualifier("courseConverter")
    private CourseConverter courseConverter;

    @Override
    public List<CourseModel> listAllCourses() {
        LOG.info("Call: " + "listAllCourses()");
        List<CourseModel> courseModels;
        List<Course> courses = courseJpaRepository.findAll();
        courseModels = courseConverter.listEntityToModel(courses);
        return courseModels;
    }

    @Override
    public void addCourse(CourseModel courseModel) {
        LOG.info("Call: " + "addCourse()");
        courseJpaRepository.save(courseConverter.modelToEntity(courseModel));
    }

    @Override
    public int removeCourse(int id) {
        LOG.info("Call: " + "removeCourse()");
        courseJpaRepository.deleteById(id);
        return 0;
    }

    @Override
    public void updateCourse(CourseModel courseModel) {
        LOG.info("Call: " + "updateCourse()");
        Course course = courseJpaRepository.findByName(courseModel.getName());
        course.setDescription(courseModel.getDescription());
        course.setPrice(courseModel.getPrice());
        course.setHours(courseModel.getHours());
        courseJpaRepository.save(course);
    }
}
