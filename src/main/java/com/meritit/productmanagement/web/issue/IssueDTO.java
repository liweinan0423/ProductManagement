package com.meritit.productmanagement.web.issue;

public class IssueDTO {
    private String version;
    private String module;
    private Integer severity;
    private String description;
    private String projectTeam;
    private String creator;

    public void setVersion(String version) {
        this.version = version;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProjectTeam(String projectTeam) {
        this.projectTeam = projectTeam;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getVersion() {
        return version;
    }

    public String getModule() {
        return module;
    }

    public Integer getSeverity() {
        return severity;
    }

    public String getDescription() {
        return description;
    }

    public String getProjectTeam() {
        return projectTeam;
    }

    public String getCreator() {
        return creator;
    }
}
