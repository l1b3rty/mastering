package org.glau.tlab.webapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DOMAIN")
public class PushWebSiteBinding {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "URL")
    private String domain;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DOMAIN_UUID")
    private String domainUUID;

    @Column(name = "IS_ACTIVE")
    private boolean isActive;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "ORGANISATION_ID")
    private Organisation organisation;

    public PushWebSiteBinding() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomainUUID() {
        return domainUUID;
    }

    public void setDomainUUID(String domainUUID) {
        this.domainUUID = domainUUID;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

}