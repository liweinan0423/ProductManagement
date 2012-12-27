package com.meritit.productmanagement.domain;

import javax.persistence.*;

@Entity(name = "Person")
public class Person {

    public static final String PROJECT_DEVELOPER = "PROJECT_DEV";
    public static final String PRODUCT_DEVELOPER = "PRODUCT_DEV";
    private String id;
    private String name;
    private String department;
    private String login;
    private String password;
    private Project project;
    private String role;


    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(100)")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Embedded
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != null ? !id.equals(person.id) : person.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
