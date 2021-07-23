package com.example.zy_manage.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    public Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(initLayout());
        initView();
        initData();
    }

    protected abstract int initLayout();

    protected abstract void initView();

    protected abstract void initData();
    public void showToast(String msg){
        Toast.makeText(mContext,msg,Toast.LENGTH_LONG).show();
    }

    public void navigateTo(Class cls){
        Intent intent=new Intent(mContext, cls);
        startActivity(intent);
    }

    public void navigateToWithFlag(Class cls, int flags){
        Intent intent=new Intent(mContext, cls);
        //FLAG_ACTIVITY_CLEAR_TASK 清除栈中之前的活动，防止从首页返回到登录页面，起始页面的尴尬发生
        //FLAG_ACTIVITY_NEW_TASK 再创建一个新的栈来存储之后的活动
        intent.setFlags(flags);
        startActivity(intent);
    }

}
