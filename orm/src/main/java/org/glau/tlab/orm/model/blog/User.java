package org.glau.tlab.orm.model.blog;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "USER")
@DiscriminatorValue("USER")
public class User extends Author {

    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;

}
