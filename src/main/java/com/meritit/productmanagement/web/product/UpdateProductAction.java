package com.meritit.productmanagement.web.product;

import com.meritit.productmanagement.application.ProductDTO;
import com.meritit.productmanagement.web.ProductManagementAction;

public class UpdateProductAction extends ProductManagementAction {

    private String id;
    private String name;
    private int cost;
    private String architecture;
    private String suitableProject;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
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
        productDTO.setId(id);
        productDTO.setName(name);
        productDTO.setCost(cost);
        productDTO.setArchitecture(architecture);
        productDTO.setSuitableProject(suitableProject);

        getFacade().updateProduct(productDTO);

        return SUCCESS;
    }
}
