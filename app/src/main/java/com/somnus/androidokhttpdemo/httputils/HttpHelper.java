package com.somnus.androidokhttpdemo.httputils;

import com.somnus.androidokhttpdemo.AppEnvironment;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.util.HashMap;
import java.util.Map;

/**
 * @date： 2016/5/17.
 * @FileName: com.somnus.androidokhttpdemo.httputils.HttpHelper.java
 * @author: Somnus
 * @Description:
 */
public class HttpHelper {
    private int tagTemp = 0;
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

         String url = AppEnvironment.BASE_URL+AppEnvironment.GETIPINFO;
        Map<String ,String> valueMap = new HashMap<String, String>();
        valueMap.put("ip", ip);
        tagTemp = AppEnvironment.HttpGetIPTAG;
        httpGet(url, valueMap,tagTemp, callBack);

    }

    private void httpGet(String _url,Map _map,int tag,Callback<?> callBack){
         OkHttpUtils.get().url(_url).params(_map).tag(tag).build().execute(callBack);
    }


    /**
     * 取消
     */
    public void removeHttp(){
        OkHttpUtils.getInstance().cancelTag(tagTemp);
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
