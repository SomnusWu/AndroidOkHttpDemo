package com.zhy.http.okhttp.callback;

import java.io.IOException;

import okhttp3.Response;

/**
 * Created by zhy on 15/12/14.
 */
public abstract class StringCallback extends Callback<String>
{
    private int tag;
    @Override
    public String parseNetworkResponse(Response response) throws IOException
    {
        tag = (int) response.request().tag();
        return response.body().string();
    }

    private int getTag(){
        return tag;
    }

}
