package com.meritit.productmanagement.web.product;

import com.meritit.productmanagement.application.ProductDTO;
import com.meritit.productmanagement.infastructure.PageUtils;
import com.meritit.productmanagement.web.BaseApplicationAction;

import java.util.List;

public class ListProductAction extends BaseApplicationAction {

    private static final int PAGE_SIZE = 10;

    private int pageNo;
    private int totalPages;
    private List<ProductDTO> productList;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<ProductDTO> getProductList() {
        return productList;
    }

    public boolean isHasNextPage() {
        return getPageNo() < getTotalPages();
    }

    public boolean isHasPreviousPage() {
        return getPageNo() > 1;
    }

    public String execute() {

        int totalCount = getFacade().countProducts();

        int start = PageUtils.getStart(getPageNo(), PAGE_SIZE, totalCount);

        if (getPageNo() <= 0) {
            setPageNo(1);
        }

        totalPages = PageUtils.getTotalPages(totalCount, PAGE_SIZE);

        productList = getFacade().listProduct(start, PAGE_SIZE);

        return SUCCESS;
    }
}
