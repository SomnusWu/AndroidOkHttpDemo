package com.somnus.androidokhttpdemo.httputils;

import android.content.Context;

import com.google.gson.Gson;
import com.somnus.androidokhttpdemo.AppEnvironment;
import com.somnus.androidokhttpdemo.model.BaseBean;
import com.somnus.androidokhttpdemo.model.IP;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Request;

/**
 * @date： 2016/5/17.
 * @FileName: com.somnus.androidokhttpdemo.httputils.HttpHelper.java
 * @author: Somnus
 * @Description:
 */
public class HttpHelper {
    private  Context context;
    public HttpHelper(Context mContext) {
        context = mContext;
    }
    private OkRequestCallBack requestCallBack;

    public void setRequestCallBack(OkRequestCallBack requestCallBack) {
        this.requestCallBack = requestCallBack;
    }

    //    /**
//     * 得到ip
//     */
    public void getIp(String ip){

        String url = AppEnvironment.BASE_URL+AppEnvironment.GETIPINFO;
        Map<String ,String> valueMap = new HashMap<String, String>();
        valueMap.put("ip", ip);
        httpGet(url, AppEnvironment.HttpGetIPTAG, valueMap, IP.class, false);
    }


    private void httpGet(String _url,  final int requestCode, final Map _map, final Class<? extends  BaseBean> beanClass,boolean isShow){

         OkHttpUtils.get().url(_url).params(_map).tag(context).build().execute(new StringCallback() {
             @Override
             public void onError(Call call, Exception e) {
                 if (null != requestCallBack)
                 requestCallBack.onResError(requestCode,call,e);
             }

             @Override
             public void onResponse(String response) {
                 if (null != requestCallBack){
                     BaseBean bean =  new Gson().fromJson(response, beanClass);
                     requestCallBack.onResSuccess(requestCode,bean);
                 }
             }

             @Override
             public void onBefore(Request request) {
                 super.onBefore(request);
             }

             @Override
             public void onAfter() {
                 super.onAfter();
             }

             @Override
             public void inProgress(float progress) {
                 super.inProgress(progress);
             }
         });
    }










    /**
     * 取消
     */
    public void removeHttp(){
        OkHttpUtils.getInstance().cancelTag(context);
    }



//    /**
//     * 当一个页面有多个请求的时候  直接传this  ,
//     */
//    public void removeHttp(Context context){
//        OkHttpUtils.getInstance().cancelTag(context);
//    }



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
