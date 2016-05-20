package com.somnus.androidokhttpdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.somnus.androidokhttpdemo.model.BaseBean;

import okhttp3.Call;

/**
 * https://github.com/hongyangAndroid/okhttp-utils
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        httpHelper = initHttpHelper(MainActivity.this);

    }

    public void onGetIp(View view){
        httpHelper.getIp("202.202.32.202");
    }


    @Override
    public void onResSuccess(int requestCode, BaseBean bean) {
        super.onResSuccess(requestCode, bean);
        Log.d("tag  -- >",bean.toString()  );
    }

    @Override
    public void onResError(int requectCode, Call call, Exception e) {
        super.onResError(requectCode, call, e);
        Log.d("error = = >",e.toString());
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
//        OkHttpUtils.getInstance().cancelTag(AppEnvironment.HttpGetIPTAG);
    }
}
