package com.faceTest.domain;

import java.util.List;

public class PageBean {
    Integer pageCount;     //页面总数  recordCount/row
    Integer recordCount;   //总记录条数
    Integer row;           //每页显示的条数
    List<Person>  page;    //每页的记录
    Integer currentPage;   //当前页面

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public List<Person> getPage() {
        return page;
    }

    public void setPage(List<Person> page) {
        this.page = page;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pageCount=" + pageCount +
                ", recordCount=" + recordCount +
                ", row=" + row +
                ", page=" + page +
                ", currentPage=" + currentPage +
                '}';
    }
}
