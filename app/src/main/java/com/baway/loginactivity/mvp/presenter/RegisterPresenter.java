package com.baway.loginactivity.mvp.presenter;

import com.baway.loginactivity.bean.Result;
import com.baway.loginactivity.core_Callback.DataCall_CallBack;
import com.baway.loginactivity.mvp.MyModel;

/**
 * @Author：刘京源
 * @E-mail： 1179348728@qq.com
 * @Date： 2019/4/25 19:12
 * @Description：描述信息
 */
public class RegisterPresenter extends BasePresenter{
    public RegisterPresenter(DataCall_CallBack dataCall_callBack) {
        super(dataCall_callBack);
    }

    @Override
    Result getModel(Object... args) throws Exception {
        return MyModel.register((String)args[0],(String)args[1]);
    }
}
