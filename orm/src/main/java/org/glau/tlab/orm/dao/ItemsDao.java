package org.glau.tlab.orm.dao;

import org.glau.tlab.orm.model.Item;

public interface ItemsDao {

    void save(Item item);

    void delete(Item item);

    void update(Item item);

    Item findById(long id);

}
