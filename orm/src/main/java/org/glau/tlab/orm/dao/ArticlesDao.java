package org.glau.tlab.orm.dao;

import org.glau.tlab.orm.model.blog.Article;

public interface ArticlesDao {

    void save();

    void update();

    void delete();

    Article find(long id);



}
