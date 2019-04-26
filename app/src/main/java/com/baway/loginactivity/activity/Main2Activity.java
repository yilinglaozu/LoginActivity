package com.baway.loginactivity.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.baway.loginactivity.R;
import com.baway.loginactivity.bean.Result;
import com.baway.loginactivity.bean.User;
import com.baway.loginactivity.core_Callback.DataCall_CallBack;
import com.baway.loginactivity.mvp.presenter.RegisterPresenter;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener, DataCall_CallBack<User> {

    private EditText mMobile,mPas;

    private RegisterPresenter presenter=new RegisterPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mMobile = findViewById(R.id.reg_mobile);
        mPas = findViewById(R.id.reg_pas);

        findViewById(R.id.reg_btn).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String mobile = mMobile.getText().toString();
        String pas = mPas.getText().toString();

        presenter.requestData(mobile,pas);

    }

    @Override
    public void success(User result) {
        Toast.makeText(this,"注册成功，请登录",Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void fail(Result result) {

        Toast.makeText(this,result.getMessage(),Toast.LENGTH_LONG).show();

    }
}
