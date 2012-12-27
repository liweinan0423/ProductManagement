package com.meritit.productmanagement.web.person;

import com.meritit.productmanagement.application.PersonDTO;
import com.meritit.productmanagement.domain.Project;
import com.meritit.productmanagement.web.ProductManagementAction;

public class UpdatePersonAction extends ProductManagementAction {

    private String id;
    private String name;
    private String department;
    private String login;
    private String role;
    private String project;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String execute() {

        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(id);
        personDTO.setName(name);
        personDTO.setDepartment(department);
        personDTO.setLogin(login);
        personDTO.setRole(role);
        personDTO.setProject(new Project(project));

        getFacade().updatePerson(personDTO);

        return SUCCESS;
    }
}
