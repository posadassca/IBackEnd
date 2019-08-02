package com.udemy.backendninja.controller.converter;

import com.udemy.backendninja.controller.entity.Course;
import com.udemy.backendninja.controller.model.CourseModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("courseConverter")
public class CourseConverter {

    //Entity --> Model
    public CourseModel entityToModel(Course course){
        CourseModel courseModel = new CourseModel();
        courseModel.setName(course.getName());
        courseModel.setDescription(course.getDescription());
        courseModel.setPrice(course.getPrice());
        courseModel.setHours(course.getHours());
        return courseModel;
    }

    //Model --> Entity
    public Course modelToEntity(CourseModel courseModel){
        Course course = new Course();
        course.setName(courseModel.getName());
        course.setDescription(courseModel.getDescription());
        course.setPrice(courseModel.getPrice());
        course.setHours(courseModel.getHours());
        return course;
    }

    //EntityList --> ModelList
    public List<CourseModel> listEntityToModel(List<Course> course){
        List<CourseModel> courseModels = new ArrayList<>();
        for(Course courseEntity : course){
            courseModels.add(entityToModel(courseEntity));
        }
        return courseModels;
    }

    //ModelList --> EntityList
    public List<Course> listModelToEntity(List<CourseModel> courseModels){
        List<Course> courses = new ArrayList<>();
        for(CourseModel courseModel : courseModels){
            courses.add(modelToEntity(courseModel));
        }
        return courses;
    }
}
