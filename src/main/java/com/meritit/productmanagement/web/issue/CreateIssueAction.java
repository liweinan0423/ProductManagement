package com.meritit.productmanagement.web.issue;

import com.meritit.productmanagement.application.ProductDTO;
import com.meritit.productmanagement.domain.Person;
import com.meritit.productmanagement.web.BaseApplicationAction;

import java.util.List;

public class CreateIssueAction extends BaseApplicationAction {

    private List<ProductDTO> productList;

    public String execute() {
        if (!"-1".equals(getCurrentUser().getId()) && !Person.PROJECT_DEVELOPER.equals(getCurrentUser().getRole())) {
            throw new UnsupportedOperationException("权限不足");
        }

        productList = getFacade().listProduct(0, getFacade().countProducts());

        return SUCCESS;
    }

    public List<ProductDTO> getProductList() {
        return productList;
    }
}
