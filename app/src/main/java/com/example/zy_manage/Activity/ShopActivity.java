package com.example.zy_manage.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zy_manage.Adapter.RvAdapter;
import com.example.zy_manage.Entity.JsonEntity;
import com.example.zy_manage.Entity.ShopEntity;
import com.example.zy_manage.MainActivity;
import com.example.zy_manage.R;
import com.example.zy_manage.Utils.OnRecyclerItemClickListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends BaseActivity {
    private RvAdapter rvAdapter;
    private RecyclerView recyclerView;
    private String json;
    private Button back;
    private List<ShopEntity> list;

    @Override
    protected int initLayout() {
        return R.layout.activity_shop;
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.recyclerview);
        //设置recyclerView为瀑布流显示，每行两个条目
        StaggeredGridLayoutManager layoutManager1 = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager1);
        rvAdapter = new RvAdapter(this,recyclerView,new ArrayList<>());
        recyclerView.setAdapter(rvAdapter);
        back = findViewById(R.id.btn_back1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateTo(MainActivity.class);
                overridePendingTransition(0, 0);//取消跳转动画
                finish();
            }
        });
        rvAdapter.setRecyclerItemClickListener(new OnRecyclerItemClickListener() {
            //点击条目事件
            @Override
            public void onItemClick(int Position, List<ShopEntity> dataList) {
                Intent intent = new Intent();
                intent.setClass(ShopActivity.this, ShopInfoActivity.class);
                ShopEntity shopEntity = dataList.get(Position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("shop", shopEntity);//传入实体类数据方法，要在该实体类上加入Serializable接口
                intent.putExtras(bundle);
                startActivity(intent);
                overridePendingTransition(0, 0);//取消跳转动画
            }
        });
    }

    @Override
    protected void initData() {
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            //获取json数据
            json = bundle.getString("Json");
            initRecyclerView();
        }

    }

    private void initRecyclerView() {
        //解析json数据，并将数据传入适配器
        Gson gson = new Gson();
        JsonEntity jsonEntity = gson.fromJson(json, JsonEntity.class);
        list = jsonEntity.getResult();
        rvAdapter.setData(list);
    }
}