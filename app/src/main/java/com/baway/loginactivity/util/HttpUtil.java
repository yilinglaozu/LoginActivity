package com.baway.loginactivity.util;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @Author：刘京源
 * @E-mail： 1179348728@qq.com
 * @Date： 2019/4/25 16:37
 * @Description：描述信息
 */
public class HttpUtil {
    private static final HttpUtil ourInstance = new HttpUtil();
    private static  HttpUtil instance;
    private OkHttpClient okHttpClient;

    public static HttpUtil getInstance() {
        //自己理解懒汉式单利
        if (instance==null){
            instance=new HttpUtil();
        }
        return ourInstance;
    }

    private HttpUtil() {
        //http拦截log
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient=new OkHttpClient.Builder()
                /* .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60,TimeUnit.SECONDS)
                .connectTimeout(60,TimeUnit.SECONDS)*/
                .addInterceptor(loggingInterceptor)
                .build();

    }

    //post请求
    public String postByOKHttp(String url,String[] keys,String[] values){
        Request.Builder requestBuilder = new Request.Builder().url(url);
        if (keys!=null){
            FormBody.Builder formBodyBuild = new FormBody.Builder();
            for (int i = 0; i <keys.length ; i++) {
                formBodyBuild.add(keys[i],values[i]);
            }
            requestBuilder.post(formBodyBuild.build());
        }
        try {
            Response result = okHttpClient.newCall(requestBuilder.build()).execute();
            return result.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }






    //get请求
    /* public  void  getByOkHttp(String url){
        getByOkHttp(url,null,null);
    }*/
    //OkHTTPClient
    //get
 /*   public  String   getByOkHttp(String url,String[] keys,String[] values){
        //网址内部拼接
        if (keys!=null){
            url+="?";
            for (int i = 0; i <keys.length ; i++) {
                if (i!=keys.length-1){
                    url=url+keys[i]+"="+values[i]+"&";
                }else{
                    url=url+keys[i]+"="+values[i];
                }
            }
        }
        //往常一样
        Request request = new Request.Builder()
                .url(url).get().build();
        try {
            Response result = okHttpClient.newCall(request).execute();
            return result.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/

}
