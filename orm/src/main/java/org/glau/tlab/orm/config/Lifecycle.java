package org.glau.tlab.orm.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lifecycle implements ServletContextListener {
    private static final Logger logger = Logger.getLogger(Lifecycle.class.getName());

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        logger.log(Level.INFO, "CONTEXT DESTROYED");
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        logger.log(Level.INFO, "CONTEXT STARTED");
    }
}
