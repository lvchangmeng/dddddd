package com.itheima.domain;

import java.io.Serializable;

public class PageBean implements Serializable {

    private Integer currentPage;//当前页码
    private Integer rows;//每页显示的条数
    private Integer start;//每页起始位置索引
    private Integer totalCount;//总记录数
    private Integer totalPage;//总页数

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        totalPage=totalCount%rows==0?(totalCount/rows):(totalCount/rows)+1;
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", rows=" + rows +
                ", start=" + start +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                '}';
    }
}
