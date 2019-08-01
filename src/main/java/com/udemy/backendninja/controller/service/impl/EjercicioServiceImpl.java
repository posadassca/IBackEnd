package com.udemy.backendninja.controller.service.impl;

import com.udemy.backendninja.controller.service.EjercicioService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service("ejercicioService")
public class EjercicioServiceImpl implements EjercicioService {

    private static final Log LOGGER = LogFactory.getLog(EjercicioServiceImpl.class);
    private static final String INFO = "Estamos en el servicio EjercicioServiceImpl";

    @Override
    public void mostrarLog() {
        LOGGER.info("Mostrando log en Consola");
    }

    @Override
    public String mensaje() {
        return INFO;
    }
}
