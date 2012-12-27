package com.meritit.productmanagement.web;

import com.meritit.productmanagement.application.ProductManagementApplicationFacade;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class ProductManagementAction extends ActionSupport implements Preparable {

    private ProductManagementApplicationFacade facade;


    public ProductManagementApplicationFacade getFacade() {
        return this.facade;
    }

    @Override
    public void prepare() throws Exception {
        facade = new ProductManagementApplicationFacade();
    }
}