package com.baway.loginactivity.core_Callback;

import com.baway.loginactivity.bean.Result;

/**
 * @Author：刘京源
 * @E-mail： 1179348728@qq.com
 * @Date： 2019/4/25 16:50
 * @Description：描述信息
 */
public interface DataCall_CallBack<T> {
    void success(T result);
    void  fail(Result result);
}
