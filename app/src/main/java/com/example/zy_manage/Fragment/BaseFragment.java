package com.example.zy_manage.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public abstract class BaseFragment extends Fragment {
    protected View mRootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mRootView == null){
            mRootView = inflater.inflate(initLayout(), container,false);
            initView();
            //此处特比重要，谨记忘写找bug找了三个小时
        }

        return mRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        //此处特比重要，谨记忘写找bug找了三个小时
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //解绑
    }

    protected abstract int initLayout();

    protected abstract void initView();

    protected abstract void initData();


    public void showToast(String msg){
        Toast.makeText(getActivity(),msg,Toast.LENGTH_LONG).show();
    }
    public void showToastSync(String msg){
        Looper.prepare();
        Toast.makeText(getActivity(),msg,Toast.LENGTH_LONG).show();
        Looper.loop();
    }
    public void navigateTo(Class cls){
        Intent intent=new Intent(getActivity(), cls);
        startActivity(intent);
        getActivity().overridePendingTransition(0, 0);
        getActivity().finish();
    }

    public void navigateToWithBundle(Class cls, Bundle bundle){
        Intent intent=new Intent(getActivity(), cls);
        intent.putExtras(bundle);
        startActivity(intent);
        getActivity().overridePendingTransition(0, 0);
        getActivity().finish();
    }





}
