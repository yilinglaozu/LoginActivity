package com.baway.loginactivity.mvp.presenter;

import com.baway.loginactivity.bean.Result;
import com.baway.loginactivity.core_Callback.DataCall_CallBack;
import com.baway.loginactivity.mvp.MyModel;

/**
 * @Author：刘京源
 * @E-mail： 1179348728@qq.com
 * @Date： 2019/4/25 17:01
 * @Description：描述信息
 */
public class LoginPresenter extends BasePresenter {

    public LoginPresenter(DataCall_CallBack dataCall_callBack) {
        super(dataCall_callBack);
    }

    Result getModel(Object... args) throws Exception {
        return MyModel.login((String)args[0],(String)args[1]);
    }
}
