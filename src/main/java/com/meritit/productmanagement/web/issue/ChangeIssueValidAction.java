package com.meritit.productmanagement.web.issue;

import com.meritit.productmanagement.domain.Person;
import com.meritit.productmanagement.web.BaseApplicationAction;

public class ChangeIssueValidAction extends BaseApplicationAction {

    private String id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String execute() {
        if (!"-1".equals(getCurrentUser()) && !Person.PROJECT_DEVELOPER.equals(getCurrentUser().getRole())) {
            throw new UnsupportedOperationException("权限不足");
        }

        getFacade().changeIssueValid(id);
        return SUCCESS;
    }

}
