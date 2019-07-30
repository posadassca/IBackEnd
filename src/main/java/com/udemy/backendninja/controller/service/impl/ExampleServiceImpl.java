package com.udemy.backendninja.controller.service.impl;

import com.udemy.backendninja.controller.model.Person;
import com.udemy.backendninja.controller.service.ExampleService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

    private static final Log LOGGER = LogFactory.getLog(ExampleServiceImpl.class);

    @Override
    public List<Person> getListPeople() {
        List<Person> people = new ArrayList<Person>();
        people.add(new Person("Simon", 0));
        people.add(new Person("Cristian", 15));
        people.add(new Person("Sebastian", 24));
        people.add(new Person("Andres", 19));
        people.add(new Person("Carolina", 28));
        LOGGER.info("HELLO FROM SERVICE");
        return people;
    }
}
