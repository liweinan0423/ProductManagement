package com.meritit.productmanagement.web.issue;

import com.meritit.productmanagement.domain.Issue;
import com.meritit.productmanagement.infastructure.PageUtils;
import com.meritit.productmanagement.web.BaseApplicationAction;

import java.util.List;


public class ListIssueAction extends BaseApplicationAction {

    private int pageNo;
    private int totalPages;
    private List<Issue> issueList;

    private static final int PAGE_SIZE = 10;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<Issue> getIssueList() {
        return issueList;
    }

    public String execute() {
        int totalCount = getFacade().countIssues();

        int start = PageUtils.getStart(getPageNo(), PAGE_SIZE, totalCount);

        if (getPageNo() <= 0) {
            setPageNo(1);
        }

        totalPages = PageUtils.getTotalPages(totalCount, PAGE_SIZE);

        issueList = getFacade().listIssues(start, PAGE_SIZE);

        return SUCCESS;
    }

}
