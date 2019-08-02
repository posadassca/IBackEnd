package com.udemy.backendninja.controller.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.backendninja.controller.entity.Course;
import com.udemy.backendninja.controller.entity.QCourse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {

    //Nomenclatura QueryDSL --> Q + Clase Java
    QCourse qCourse = QCourse.course;

    @PersistenceContext
    private EntityManager em;

    public Course find(boolean exist){
        JPAQuery<Course> query = new JPAQuery<Course>(em);

        BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));

        if(exist){
            Predicate predicate2 = qCourse.id.eq(23);
            predicateBuilder.and(predicate2);
        } else{
            Predicate predicate3 = qCourse.name.endsWith("OP");
            predicateBuilder.or(predicate3);
        }

        return query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();
//        Horas entre 7 y 10 (deberia no traer 1 curso)
//        List<Course> courses = query.select(qCourse).from(qCourse).where(qCourse.hours.between(7, 10)).fetch();
    }

}
