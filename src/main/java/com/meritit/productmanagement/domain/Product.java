package com.meritit.productmanagement.domain;

import org.apache.commons.lang3.StringUtils;

public class Product {
    private String name;
    private Integer cost;
    private String architecture;

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
        this.architecture = architecture;
    }

    public String getArchitecture() {
        return architecture;
    }
}
