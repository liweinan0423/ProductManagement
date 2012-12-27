package com.meritit.productmanagement.web.person;

import com.meritit.productmanagement.application.PersonDTO;
import com.meritit.productmanagement.domain.Department;
import com.meritit.productmanagement.domain.Project;
import com.meritit.productmanagement.web.ProductManagementAction;

import java.util.List;

public class EditPersonAction extends ProductManagementAction {

    private String id;
    private PersonDTO person;
    private List<Project> projectList;
    private List<Department> departmentList;

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setId(String id) {
        this.id = id;
    }


    public PersonDTO getPerson() {
        return person;
    }

    public String execute() {
        person = getFacade().findPersonById(id);
        projectList = getFacade().allProjects();
        departmentList = getFacade().allDepartments();
        return SUCCESS;
    }
}
