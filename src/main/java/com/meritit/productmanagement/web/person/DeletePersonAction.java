package com.meritit.productmanagement.web.person;

import com.meritit.productmanagement.web.ProductManagementAction;

public class DeletePersonAction extends ProductManagementAction {

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String execute() {
        getFacade().deletePersonById(id);
        return SUCCESS;
    }
}