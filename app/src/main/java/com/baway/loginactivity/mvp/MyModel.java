package com.baway.loginactivity.mvp;

import android.util.Log;

import com.baway.loginactivity.bean.Result;
import com.baway.loginactivity.bean.User;
import com.baway.loginactivity.util.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.lang.reflect.Type;

/**
 * @Author：刘京源
 * @E-mail： 1179348728@qq.com
 * @Date： 2019/4/25 16:51
 * @Description：描述信息
 */
public class MyModel {
    //登录请求的数据 两个参数
    public static Result login(final String mobile, final String password) throws JSONException {
        String result = HttpUtil.getInstance().postByOKHttp(
                "http://172.17.8.100/small/user/v1/login",
                new String[]{"phone","pwd"},
                new String[]{mobile,password});
        if (result!=null) {
            Type type = new TypeToken<Result<User>>() {}.getType();
            Gson gson = new Gson();
            Result<User> data = gson.fromJson(result,type);
            return data;
        }
        return new Result();
    }









    //注册
    public static Result register(final String mobile,final String password) throws JSONException {
        String result = HttpUtil.getInstance().postByOKHttp(
                "http://172.17.8.100/small/user/v1/register",
                new String[]{"phone","pwd"},
                new String[]{mobile,password});
        if (result!=null) {
            Type type = new TypeToken<Result<User>>() {}.getType();
            Gson gson = new Gson();
            Result<User> data = gson.fromJson(result,type);
            return data;
        }
        return new Result();
    }
}
