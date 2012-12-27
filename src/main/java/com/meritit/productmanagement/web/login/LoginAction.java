package com.meritit.productmanagement.web.login;

import com.meritit.productmanagement.application.PersonDTO;
import com.meritit.productmanagement.web.ProductManagementAction;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class LoginAction extends ProductManagementAction implements SessionAware {

    private String login;
    private String password;

    private Map<String, Object> session;

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

    public String execute() {

        PersonDTO personDTO = getFacade().login(login, password);

        session.put("principal", personDTO);

        return SUCCESS;
    }


    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
