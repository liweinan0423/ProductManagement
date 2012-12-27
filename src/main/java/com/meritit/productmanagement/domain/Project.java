package com.meritit.productmanagement.domain;

import javax.persistence.Basic;
import javax.persistence.Embeddable;

@Embeddable
public class Project {

    private String name;


    public Project(String name) {
        this.name = name;
    }

    public Project() {
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (name != null ? !name.equals(project.name) : project.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}