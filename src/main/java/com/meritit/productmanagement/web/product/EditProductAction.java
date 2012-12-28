package com.meritit.productmanagement.web.product;

import com.meritit.productmanagement.application.ProductDTO;
import com.meritit.productmanagement.web.BaseApplicationAction;

public class EditProductAction extends BaseApplicationAction {

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
