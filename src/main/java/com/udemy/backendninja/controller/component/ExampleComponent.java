package com.udemy.backendninja.controller.component;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("exampleComponent")
public class ExampleComponent {

    private static final Log LOGGER = LogFactory.getLog(ExampleComponent.class);

    public void sayHello(){
        LOGGER.info("HELLO FROM EXAMPLECOMPONENT");
    }
}
