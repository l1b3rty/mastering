package org.glau.tlab.webapp.config;

import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.logging.Level;
import java.util.logging.Logger;

//@Component
public class Lifecycle implements ServletContextListener {
    private static final Logger logger = Logger.getLogger(Lifecycle.class.getName());

    @EventListener(ContextStartedEvent.class)
    public void onContextStarted() {
        logger.log(Level.INFO, "CONTEXT STARTED (1)");
    }

    @EventListener(ContextStoppedEvent.class)
    public void onContextStopped() {
        logger.log(Level.INFO, "CONTEXT STOPPED (2)");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        logger.log(Level.INFO, "CONTEXT DESTROYED");
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        logger.log(Level.INFO, "CONTEXT STARTED");
    }
}
