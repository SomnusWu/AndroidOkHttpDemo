package com.somnus.androidokhttpdemo.model;

/**
 * @FileName: com.somnus.retrofit.androidretrofitdemo.model.BaseBean.java
 * @author: Somnus
 * @Description:
 */
public class BaseBean {
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "code=" + code +
                '}';
    }
}
