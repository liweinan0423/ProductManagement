package com.meritit.productmanagement.web.product;

import com.meritit.productmanagement.application.ProductDTO;
import com.meritit.productmanagement.web.ProductManagementAction;

public class SaveProductAction extends ProductManagementAction {

    private String name;
    private Integer cost;
    private String architecture;
    private String suitableProject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public String getSuitableProject() {
        return suitableProject;
    }

    public void setSuitableProject(String suitableProject) {
        this.suitableProject = suitableProject;
    }

    public String execute() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(name);
        productDTO.setCost(cost);
        productDTO.setArchitecture(architecture);
        productDTO.setSuitableProject(suitableProject);
        getFacade().saveProduct(productDTO);
        return SUCCESS;
    }
}