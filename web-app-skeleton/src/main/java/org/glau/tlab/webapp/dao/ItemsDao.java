package org.glau.tlab.webapp.dao;

import org.glau.tlab.webapp.model.Item;

public interface ItemsDao {

    void save(Item item);

    void delete(Item item);

    void update(Item item);

    Item findById(long id);

}
