package com.somnus.androidokhttpdemo;

import com.google.gson.Gson;
import com.somnus.androidokhttpdemo.model.IP;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Response;

/**
 * @date： 2016/5/17.
 * @FileName: com.somnus.androidokhttpdemo.IPCallBack.java
 * @author: Somnus
 * @Description:
 */
public abstract class  IPCallBack  extends Callback<IP>{
    private int tag = 0;
    @Override
    public IP parseNetworkResponse(Response response) throws Exception {
        String string = response.body().string();
        IP ip = new Gson().fromJson(string, IP.class);
        tag  = (int) response.request().tag();
        return ip;
    }

    public int getTag(){
        return tag;
    }

}
