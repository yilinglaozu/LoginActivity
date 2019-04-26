package com.baway.loginactivity.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.baway.loginactivity.R;
import com.baway.loginactivity.bean.Result;
import com.baway.loginactivity.bean.User;
import com.baway.loginactivity.core_Callback.DataCall_CallBack;
import com.baway.loginactivity.mvp.presenter.LoginPresenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        DataCall_CallBack<User> {

    private EditText mobile1,password1;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mobile1=findViewById(R.id.login_mobile);
        password1=findViewById(R.id.login_pas);
        findViewById(R.id.login_btn).setOnClickListener(this);
        findViewById(R.id.login_reg).setOnClickListener(this);

        loginPresenter=new LoginPresenter(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.login_btn) {//点击登录按钮
            final String mobile = mobile1.getText().toString();
            final String password = password1.getText().toString();
            //登录请求
            loginPresenter.requestData(mobile,password);

        }else if (v.getId()==R.id.login_reg){
            //点击注册按钮
            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);

        }
    }

    @Override
    public void success(User result) {
        Toast.makeText(this,result.getUserId()+"  "+result.getSessionId(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void fail(Result result) {
        Toast.makeText(this,"失败："+result.getMessage(),Toast.LENGTH_LONG).show();
    }
}
