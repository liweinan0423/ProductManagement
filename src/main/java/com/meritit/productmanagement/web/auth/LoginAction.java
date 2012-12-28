package com.meritit.productmanagement.web.auth;

import com.meritit.productmanagement.application.PersonDTO;
import com.meritit.productmanagement.domain.LoginException;
import com.meritit.productmanagement.web.BaseApplicationAction;

public class LoginAction extends BaseApplicationAction {

    private String login;
    private String password;
    private String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String login() {

        PersonDTO personDTO = null;
        try {
            personDTO = getFacade().login(login, password);
        } catch (LoginException e) {
            e.printStackTrace();
            message = e.getMessage();
            return INPUT;
        }

        getSession().put("principal", personDTO);

        return SUCCESS;
    }

    public String logout() {
        getSession().clear();
        return LOGIN;
    }
}
