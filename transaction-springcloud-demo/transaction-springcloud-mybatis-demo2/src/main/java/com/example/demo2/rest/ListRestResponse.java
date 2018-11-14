package com.example.demo2.rest;

/**
 * @author xuezhijian
 * @date 2018/7/28 下午5:06
 * @description
 */

public class ListRestResponse<T> extends BaseResponse{

    private T result;

    private int count;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ListRestResponse count(int count) {
        this.setCount(count);
        return this;
    }

    public ListRestResponse count(Long count) {
        this.setCount(count.intValue());
        return this;
    }

    public ListRestResponse message(String message) {
        super.setMessage(message);
        return this;
    }

    public ListRestResponse result(T result) {
        this.setResult(result);
        return this;
    }


}
