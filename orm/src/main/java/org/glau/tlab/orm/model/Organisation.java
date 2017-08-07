/*
package org.glau.tlab.orm.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORGANISATION")
public class Organisation {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "ORG_NAME")
    private String name;

    @Column(name = "DESC")
    private String description;

    @OneToMany(mappedBy = "organisation", cascade = {
        CascadeType.MERGE, CascadeType.REMOVE}
    )
    private List<PushWebSiteBinding> pushWebSiteBindings = new ArrayList<>();

    public Organisation() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PushWebSiteBinding> getPushWebSiteBindings() {
        return pushWebSiteBindings;
    }

    public void setPushWebSiteBindings(List<PushWebSiteBinding> pushWebSiteBindings) {
        this.pushWebSiteBindings = pushWebSiteBindings;
    }

    public void addDomain(PushWebSiteBinding pushWebSiteBinding) {
        pushWebSiteBinding.setOrganisation(this);
        pushWebSiteBindings.add(pushWebSiteBinding);
    }
}
*/
