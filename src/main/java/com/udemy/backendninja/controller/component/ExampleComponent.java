package com.udemy.backendninja.controller.component;

import com.udemy.backendninja.controller.entity.Course;
import com.udemy.backendninja.controller.repository.CourseJpaRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("exampleComponent")
public class ExampleComponent {

    private static final Log LOGGER = LogFactory.getLog(ExampleComponent.class);

    @Autowired
    @Qualifier("courseJpaRepository")
    private CourseJpaRepository courseJpaRepository;

    public void sayHello(){
        courseJpaRepository.save(new Course());
        LOGGER.info("HELLO FROM EXAMPLECOMPONENT");
    }
}
