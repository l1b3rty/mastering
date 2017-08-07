package org.glau.tlab.orm.services;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE/*, proxyMode = ScopedProxyMode.TARGET_CLASS*/)
public class SimplePrototypeService {

    private static final Logger log = Logger.getLogger(SimplePrototypeService.class.getName());

    private static final AtomicInteger instanceIdIncrementor = new AtomicInteger(0);

    private final int beanId;

    public SimplePrototypeService() {
        log.log(Level.INFO, "Ctor SimplePrototypeService");
        beanId = instanceIdIncrementor.incrementAndGet();
        log.log(Level.INFO, "Ctor SimplePrototypeService done");
    }

    public int getBeanId() {
        return beanId;
    }

}
