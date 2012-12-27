package com.meritit.productmanagement.web.product;

import com.meritit.productmanagement.application.ProductDTO;
import com.meritit.productmanagement.web.ProductManagementAction;

public class EditProductAction extends ProductManagementAction {

    private String id;
    private ProductDTO product;

    public void setId(String id) {
        this.id = id;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public String execute() {
        product = getFacade().findProductById(id);
        return SUCCESS;
    }
}
