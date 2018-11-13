package com.example.demo1.rest;

/**
 * @author xuezhijian
 * @date 2018/7/28 下午5:06
 * @description
 */

public class ObjectRestResponse<T> extends BaseResponse {

    private T data;

    private boolean rel;

    public ObjectRestResponse(){}

    public ObjectRestResponse(int status, String message){
        super(status,message);
    }

    public boolean isRel() {
        return rel;
    }

    public void setRel(boolean rel) {
        this.rel = rel;
    }

    public ObjectRestResponse<T> rel(boolean rel) {
        this.setRel(rel);
        return this;
    }

    public ObjectRestResponse<T> data(T data) {
        this.setData(data);
        return this;
    }

    public ObjectRestResponse<T> message(String message) {
        super.setMessage(message);
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
