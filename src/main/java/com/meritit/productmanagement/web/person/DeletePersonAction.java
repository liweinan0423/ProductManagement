package com.meritit.productmanagement.web.person;

import com.meritit.productmanagement.web.BaseApplicationAction;

public class DeletePersonAction extends BaseApplicationAction {

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String execute() {
        getFacade().deletePersonById(id);
        return SUCCESS;
    }
}