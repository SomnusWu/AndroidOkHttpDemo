package com.somnus.androidokhttpdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.somnus.androidokhttpdemo.httputils.HttpHelper;
import com.somnus.androidokhttpdemo.httputils.OkRequestCallBack;
import com.somnus.androidokhttpdemo.model.BaseBean;

import okhttp3.Call;

/**
 * @date： 2016/5/17.
 * @FileName: com.somnus.androidokhttpdemo.BaseActivity.java
 * @author: Somnus
 * @Description:
 */
public class BaseActivity extends AppCompatActivity implements OkRequestCallBack {

    public HttpHelper httpHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public HttpHelper initHttpHelper(Context mContext){
        httpHelper = new HttpHelper(this);
        httpHelper.setRequestCallBack(this);
        return httpHelper;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (httpHelper != null){
            httpHelper.removeHttp();
        }
    }

    @Override
    public void onResBefer(int reqeustCode) {

    }

    @Override
    public void onResAfter(int requestCode) {

    }

    @Override
    public void onResProgress(int requestCode, int progress) {

    }

    @Override
    public void onResError(int requectCode, Call call, Exception e) {

    }

    @Override
    public void onResSuccess(int requestCode, BaseBean bean) {

    }
}
