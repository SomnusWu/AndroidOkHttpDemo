package com.somnus.androidokhttpdemo.httputils;

import com.somnus.androidokhttpdemo.AppEnvironment;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

/**
 * @date： 2016/5/17.
 * @FileName: com.somnus.androidokhttpdemo.httputils.HttpHelper.java
 * @author: Somnus
 * @Description:
 */
public class HttpHelper {
    private static HttpHelper mInstance;

    public static HttpHelper getInstance()
    {
        if (mInstance == null)
        {
            synchronized (HttpHelper.class)
            {
                if (mInstance == null)
                {
                    mInstance = new HttpHelper();
                }
            }
        }
        return mInstance;
    }


    /**
     * 得到ip
     */
    public void getIp(String ip,Callback<?> callBack){
       OkHttpUtils.get().url(AppEnvironment.BASE_URL+AppEnvironment.GETIPINFO)
        .addParams("ip",ip).tag(AppEnvironment.HttpGetIPTAG).build().execute(callBack);
    }





//    Callback callBack = new Callback() {
//        @Override
//        public Object parseNetworkResponse(Response response) throws Exception {
//            Log.d("responseresp== >",response.toString());
//            Log.d("parseNetworkResponse-->",response.body().string());
//            Log.d("tagtagtag -- >",   response.request().tag().toString());
//            return response.body().string();
//        }
//
//        @Override
//        public void onError(Call call, Exception e) {
//            Log.d("onError-->",call.toString());
//        }
//
//        @Override
//        public void onResponse(Object response) {
//            Log.d("onResponse==>",response.toString());
//     }
//
//    };
}
