package com.example.demo2.rest.page;

import java.io.Serializable;
import java.util.List;

/**
 * @author zj
 * @date 2017/7/9 下午10:43
 * @description
 */

public class PageInfo<T> implements Serializable {
    private static final long serialVersionUID = 591588803811084738L;

    /** 当前页 **/
    private int currentPage = 0;

    /** 每页显示记录数 **/
    private int pageSize = 10;

    /** 总页数 **/
    private int totalPage = 0;

    /** 总记录数 **/
    private long totalRecord = 0L;

    private List<T> datas;

    public PageInfo(){}

    public PageInfo(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        if(this.currentPage < 0) {
            this.currentPage = 0;
        }
        if(this.pageSize <= 0) {
            this.pageSize = 1;
        }
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getCurrentPage() {
        if(currentPage < 0) {
            return 0;
        }
        return currentPage;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getPageSize() {
        if(pageSize <= 0) {
            return 1;
        }
        return pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalRecord() {
        return totalRecord;
    }
    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<T> getDatas() {
        return datas;
    }
    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}
