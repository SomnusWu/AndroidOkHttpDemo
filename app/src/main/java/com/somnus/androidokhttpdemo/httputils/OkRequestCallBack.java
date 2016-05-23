package com.somnus.androidokhttpdemo.httputils;

import com.somnus.androidokhttpdemo.model.BaseBean;

import okhttp3.Call;
import okhttp3.Request;

/**
 * @date： 2016/5/20.
 * @FileName: com.somnus.androidokhttpdemo.httputils.OkRequestCallBack.java
 * @author: Somnus
 * @Description:
 */
public interface OkRequestCallBack {
    public   void onResBefer(int reqeustCode, Request request);
    public   void onResAfter(int requestCode);
    public   void onResProgress(int requestCode,float progress);
    public   void onResError(int requectCode,Call call, Exception e);
    public   void onResSuccess(int requestCode,BaseBean bean);
}
