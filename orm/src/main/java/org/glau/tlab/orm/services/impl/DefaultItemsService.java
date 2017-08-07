package org.glau.tlab.orm.services.impl;

import org.glau.tlab.orm.dao.ItemsDao;
import org.glau.tlab.orm.model.Item;
import org.glau.tlab.orm.services.ItemsService;
import org.glau.tlab.orm.services.SimplePrototypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Level;
import java.util.logging.Logger;

//@Service
class DefaultItemsService implements ItemsService {

    private static final Logger log = Logger.getLogger(DefaultItemsService.class.getName());

    private ItemsDao dao;

    private SimplePrototypeService prototypeService;

    @Autowired
    public DefaultItemsService(ItemsDao dao) {
        this.dao = dao;
    }


    @Transactional
    @Override
    public Item getById(long id) {
        log.log(Level.INFO, "(1) Prototype BeanId: " + getPrototypeService().getBeanId()/*"0 - hardcode"*/);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.log(Level.WARNING, "Interrupted", e);
        }

        log.log(Level.INFO, "(2) Prototype BeanId: " + getPrototypeService().getBeanId()/*"0 - hardcode"*/);
        return dao.findById(id);
    }

    public SimplePrototypeService getPrototypeService() {
        return prototypeService;
    }

    @Autowired
    public void setPrototypeService(SimplePrototypeService prototypeService) {
        this.prototypeService = prototypeService;
    }

}
