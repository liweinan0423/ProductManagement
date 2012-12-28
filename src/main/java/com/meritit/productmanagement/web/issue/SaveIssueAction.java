package com.meritit.productmanagement.web.issue;

import com.meritit.productmanagement.web.BaseApplicationAction;

public class SaveIssueAction extends BaseApplicationAction {

    private String productId;
    private String version;
    private String module;
    private String severity;
    private String projectTeam;
    private String creator;
    private String description;


    public String execute() {

        IssueDTO issueDTO = new IssueDTO();
        issueDTO.setVersion(version);
        issueDTO.setModule(module);
        issueDTO.setSeverity(Integer.valueOf(severity));
        issueDTO.setDescription(description);
        issueDTO.setProjectTeam(projectTeam);
        issueDTO.setCreator(creator);

        getFacade().newIssue(issueDTO, productId);

        return SUCCESS;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProjectTeam() {
        return projectTeam;
    }

    public void setProjectTeam(String projectTeam) {
        this.projectTeam = projectTeam;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
