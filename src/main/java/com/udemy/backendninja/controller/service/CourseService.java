package com.udemy.backendninja.controller.service;

import com.udemy.backendninja.controller.entity.Course;
import com.udemy.backendninja.controller.model.CourseModel;

import java.util.List;

public interface CourseService {

    public abstract List<CourseModel> listAllCourses();
    public abstract void addCourse(CourseModel course);
    public abstract int removeCourse(int id);
    public abstract void updateCourse(CourseModel course);

}
