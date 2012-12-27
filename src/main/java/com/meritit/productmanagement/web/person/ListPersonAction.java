package com.meritit.productmanagement.web.person;

import com.meritit.productmanagement.application.PersonDTO;
import com.meritit.productmanagement.infastructure.PageUtils;
import com.meritit.productmanagement.web.ProductManagementAction;

import java.util.List;

public class ListPersonAction extends ProductManagementAction {

    private static final int PAGE_SIZE = 10;

    private int pageNo;
    private int totalPages;
    private List<PersonDTO> personList;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<PersonDTO> getPersonList() {
        return personList;
    }

    public boolean isHasNextPage() {
        return getPageNo() < getTotalPages();
    }

    public boolean isHasPreviousPage() {
        return getPageNo() > 1;
    }

    public String execute() {

        int totalCount = getFacade().countPersons();

        int start = PageUtils.getStart(getPageNo(), PAGE_SIZE, totalCount);

        if (getPageNo() <= 0) {
            setPageNo(1);
        }

        totalPages = PageUtils.getTotalPages(totalCount, PAGE_SIZE);

        personList = getFacade().listPerson(start, PAGE_SIZE);

        return SUCCESS;
    }
}
