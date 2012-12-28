package com.meritit.productmanagement.web;

import com.meritit.productmanagement.application.PersonDTO;
import com.meritit.productmanagement.application.ProductManagementApplicationFacade;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public abstract class BaseApplicationAction extends ActionSupport implements Preparable, SessionAware {

    private ProductManagementApplicationFacade facade;
    private Map<String, Object> session;
    private PersonDTO currentUser;


    public ProductManagementApplicationFacade getFacade() {
        return this.facade;
    }

    @Override
    public void prepare() throws Exception {
        facade = new ProductManagementApplicationFacade();
        currentUser = (PersonDTO) session.get("principal");
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public PersonDTO getCurrentUser() {
        return currentUser;
    }
}