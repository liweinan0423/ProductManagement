package com.meritit.productmanagement.infastructure;

public class PageUtils {

    public static int getTotalPages(int totalCount, int pageSize) {

        if (totalCount == 0 || pageSize == 0) {
            return 1;
        }

        if (totalCount % pageSize == 0) {
            return totalCount / pageSize;
        } else {
            return totalCount / pageSize + 1;
        }
    }

    public static int getStart(int pageNo, int pageSize, int totalCount) {
        if (pageNo <= 0) {
            pageNo = 1;
        }

        int totalPages = getTotalPages(totalCount, pageSize);


        if (pageNo > totalPages) {
            pageNo = totalPages;
        }

        return (pageNo - 1) * pageSize;
    }

}
