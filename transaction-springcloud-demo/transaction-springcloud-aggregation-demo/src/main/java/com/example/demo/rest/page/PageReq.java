package com.example.demo.rest.page;

import java.io.Serializable;

/**
 * @author zj
 * @date 2017/7/9 下午3:36
 * @description
 */

public class PageReq implements Serializable {
    private static final long serialVersionUID = 6297178964005032338L;

    private static final int MIN_PAGE = 0;

    private static final int MIN_SIZE = 0;
    private static final int MAX_SIZE = 200;
    private static final int DEFAULT_SIZE = 10;

    /** 当前页(从0开始) **/
    private int page;

    /** 一页多少条记录 **/
    private int size;

    /** 指定要返回的第一行的偏移量,初始行的偏移量是0(不是1) **/
    private int offset;

    /** 指定返回行的最大数目 **/
    private int limit;

    public PageReq(){}

    public PageReq(int page, int size) {
        this.page = page;
        this.size = size;
        if(this.page < MIN_PAGE) {
            this.page = MIN_PAGE;
        }
        if(this.size <= MIN_SIZE) {
            this.size = DEFAULT_SIZE;
        } else if(this.size > MAX_SIZE){
            this.size = MAX_SIZE;
        }
        this.offset = this.page * this.size;
        this.limit = this.size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
