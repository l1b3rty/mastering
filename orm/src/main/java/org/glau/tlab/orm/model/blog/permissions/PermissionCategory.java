package org.glau.tlab.orm.model.blog.permissions;

import javax.persistence.*;

@Entity
@Table(name = "PERMISSION_CATEGORY")
public class PermissionCategory {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "PARENT_CAT_ID")
    private PermissionCategory parentCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PermissionCategory getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(PermissionCategory parentCategory) {
        this.parentCategory = parentCategory;
    }
}
