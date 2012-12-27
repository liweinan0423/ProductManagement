package com.meritit.productmanagement.application;

public class ProductDTO {

    private String id;
    private String name;
    private Integer cost;
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
}
