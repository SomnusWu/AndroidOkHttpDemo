package com.somnus.androidokhttpdemo.httputils;

import com.google.gson.Gson;
import com.somnus.androidokhttpdemo.model.BaseBean;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @date： 2016/5/18.
 * @FileName: com.somnus.androidokhttpdemo.OkHttPCallBack.java
 * @author: Somnus
 * @Description:
 */
public class OkHttPCallBack extends Callback<BaseBean>{

    private int requestCode;
    private Class<? extends BaseBean> beanClass;
    private boolean isShow;
    private OkRequestCallBack requestCallBack;

    public void setRequestCallBack(OkRequestCallBack requestCallBack) {
        this.requestCallBack = requestCallBack;
    }

    @Override
    public BaseBean parseNetworkResponse(Response response) throws Exception {
        String string = response.body().string();
        BaseBean bean =  new Gson().fromJson(string, beanClass);
        return bean;
    }

    @Override
    public void onError(Call call, Exception e) {
        if (null!=requestCallBack)
        requestCallBack.onResError(requestCode,call,e);
    }

    @Override
    public void onResponse(BaseBean response) {
        if (null!=requestCallBack)
        requestCallBack.onResSuccess(requestCode,response);
    }


    public OkHttPCallBack(int requestCode,Class<? extends  BaseBean> beanClass,boolean isShow){
        this.requestCode = requestCode;
        this.beanClass = beanClass;
        this.isShow = isShow;
    }

}
