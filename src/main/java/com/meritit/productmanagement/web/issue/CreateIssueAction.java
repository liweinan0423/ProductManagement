package com.meritit.productmanagement.web.issue;

import com.meritit.productmanagement.application.PersonDTO;
import com.meritit.productmanagement.application.ProductDTO;
import com.meritit.productmanagement.domain.Person;
import com.meritit.productmanagement.web.BaseApplicationAction;

import java.util.List;

public class CreateIssueAction extends BaseApplicationAction {

    private List<ProductDTO> productList;
    private PersonDTO currentUser;

    public String execute() {
        currentUser = (PersonDTO) getSession().get("principal");
        if (!"-1".equals(currentUser.getId()) && !Person.PROJECT_DEVELOPER.equals(currentUser)) {
            throw new UnsupportedOperationException("权限不足");
        }

        productList = getFacade().listProduct(0, getFacade().countProducts());

        return SUCCESS;
    }

    public PersonDTO getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(PersonDTO currentUser) {
        this.currentUser = currentUser;
    }

    public List<ProductDTO> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductDTO> productList) {
        this.productList = productList;
    }
}
