package org.glau.tlab.orm.model.blog;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "ARTICLE_TAGS")
public class ArticleTag {

    @Id
    @ManyToOne
    private Article article;

    @Id
    @ManyToOne
    private Tag tag;

    public ArticleTag() { }

    public ArticleTag(Article article, Tag tag) {
        this.article = article;
        this.tag = tag;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleTag that = (ArticleTag) o;

        if (!article.equals(that.article)) return false;
        return tag.equals(that.tag);

    }

    @Override
    public int hashCode() {
        return Objects.hash(article, tag);
    }
}
