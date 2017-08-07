package org.glau.tlab.orm.dao.impl;

import org.glau.tlab.orm.dao.ArticlesDao;
import org.glau.tlab.orm.model.blog.Article;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DefaultArticlesDao implements ArticlesDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save() {
        //entityManager.persist();
    }

    @Override
    public void update() {
        //entityManager.merge()
    }

    @Override
    public void delete() {
        //entityManager.remove();
    }

    @Override
    public Article find(long id) {
        return entityManager.find(Article.class, id);
    }
}
