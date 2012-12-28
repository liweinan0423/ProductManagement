package com.meritit.productmanagement.domain;

import java.util.Date;

public class IssueService {
    private final IssueRepository issueRepository;

    public IssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    public void changeIssueValid(String id) {
        Issue issue = issueRepository.findById(id);
        issue.setValid(!issue.isValid());
        issueRepository.update(issue);
    }

    public void resolveIssue(String id, Person currentUser) {
        Issue issue = issueRepository.findById(id);
        issue.setStatus("已解决");
        issue.setResolveDate(new Date());
        issue.setResolver(currentUser.getName());
        issueRepository.update(issue);
    }
}
