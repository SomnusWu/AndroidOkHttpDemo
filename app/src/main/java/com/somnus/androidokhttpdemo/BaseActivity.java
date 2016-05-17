package com.somnus.androidokhttpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.somnus.androidokhttpdemo.httputils.HttpHelper;

/**
 * @date： 2016/5/17.
 * @FileName: com.somnus.androidokhttpdemo.BaseActivity.java
 * @author: Somnus
 * @Description:
 */
public class BaseActivity extends AppCompatActivity {

    public HttpHelper httpHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        httpHelper =HttpHelper.getInstance();
    }
}
