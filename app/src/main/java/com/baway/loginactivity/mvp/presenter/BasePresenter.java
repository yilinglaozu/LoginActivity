package com.baway.loginactivity.mvp.presenter;

import android.os.Handler;
import android.os.Message;

import com.baway.loginactivity.bean.Result;
import com.baway.loginactivity.core_Callback.DataCall_CallBack;

/**
 * @Author：刘京源
 * @E-mail： 1179348728@qq.com
 * @Date： 2019/4/25 17:01
 * @Description：描述信息
 */
public abstract class BasePresenter {
    //调用的接口唯一接口
    private DataCall_CallBack dataCall_callBack;
    public BasePresenter(DataCall_CallBack dataCall_callBack){
        this.dataCall_callBack=dataCall_callBack;
    }
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Result result= (Result) msg.obj;
            if (result.getStatus().equals("0000")){
                dataCall_callBack.success(result.getResult());
            }else {
                dataCall_callBack.fail(result);
            }

        }
    };



    public void requestData(Object...args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = handler.obtainMessage();
                Result result;
                try {
                    result = getModel(args);
                } catch (Exception e) {
                    result = new Result();
                    result.setMessage(e.getMessage());
                }
                message.obj = result;
                handler.sendMessage(message);
            }
        }).start();
    }
    abstract   Result getModel(Object...args) throws Exception;

    public  void  unBind(){
        dataCall_callBack=null;
    }

}
