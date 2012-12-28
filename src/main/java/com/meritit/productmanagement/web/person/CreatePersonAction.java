package com.meritit.productmanagement.web.person;

import com.meritit.productmanagement.domain.Department;
import com.meritit.productmanagement.domain.Project;
import com.meritit.productmanagement.web.BaseApplicationAction;

import java.util.List;

public class CreatePersonAction extends BaseApplicationAction {

    private List<Project> projectList;
    private List<Department> departmentList;

    public List<Project> getProjectList() {
        return this.projectList;
    }

    public List<Department> getDepartmentList() {
        return this.departmentList;
    }

    public String execute() {
        projectList = getFacade().allProjects();
        departmentList = getFacade().allDepartments();
        return SUCCESS;
    }
}
