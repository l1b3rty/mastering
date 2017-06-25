package org.glau.tlab.webapp.dao.impl;

import org.glau.tlab.webapp.dao.ItemsDao;
import org.glau.tlab.webapp.model.Item;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultItemsDao implements ItemsDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void save(Item item) {
        sessionFactory.getCurrentSession().save(item);
    }

    @Override
    public void delete(Item item) {
        sessionFactory.getCurrentSession().delete(item);
    }

    @Override
    public void update(Item item) {
        sessionFactory.getCurrentSession().update(item);
    }

    @Override
    public Item findById(long id) {
        return sessionFactory.getCurrentSession()
            .get(Item.class, id);
    }

}
