package org.glau.tlab.orm.model.blog.permissions;

import javax.persistence.*;

@Entity
@Table(name = "PERMISSIONS")
public class Permission {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private PermissionCategory category;

    @OneToMany

    private List<PermissionAction> actions;



}
