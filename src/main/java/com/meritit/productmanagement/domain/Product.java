package com.meritit.productmanagement.domain;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class Product {

    private static final String[] ARCHITECTURE_VALUES = {"J2EE", "Java桌面", ".Net", "Domino", "Android"};
    private static final String[] SUITABLE_PROJECT_VALUES = {"企业应用", "移动应用", "企业集成", "数据分析"};

    private String name;
    private Integer cost;
    private String architecture;



    private String suitableProject;
    private Object id;

    public void setName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new ValidationException("name", ValidationException.NOT_BLANK);
        }

        if (name.length() > 100) {
            throw new ValidationException("name", ValidationException.TOO_LONG);
        }
        this.name = name;
    }

    public void setCost(Integer cost) {
        if (cost == null) {
            throw new ValidationException("cost", ValidationException.NOT_NULL);
        }

        if (String.valueOf(cost).length() > 7) {
            throw new ValidationException("cost", ValidationException.TOO_LONG);
        }
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setArchitecture(String architecture) {
        if (StringUtils.isBlank(architecture)) {
            throw new ValidationException("architecture", ValidationException.NOT_BLANK);
        }

        if (architecture.length() > 20) {
            throw new ValidationException("architecture", ValidationException.TOO_LONG);
        }

        if (!ArrayUtils.contains(ARCHITECTURE_VALUES, architecture)) {
            throw new ValidationException("architecture", ValidationException.INCORRECT_VALUE);
        }

        this.architecture = architecture;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setSuitableProject(String suitableProject) {
        if (StringUtils.isBlank(suitableProject)) {
            throw new ValidationException("suitableProject", ValidationException.NOT_BLANK);
        }

        if (!ArrayUtils.contains(SUITABLE_PROJECT_VALUES, suitableProject)) {
            throw new ValidationException("suitableProject", ValidationException.INCORRECT_VALUE);
        }
        this.suitableProject = suitableProject;
    }

    public String getSuitableProject() {
        return suitableProject;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
