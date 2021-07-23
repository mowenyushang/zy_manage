package com.example.zy_manage.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.zy_manage.Entity.ShopEntity;
import com.example.zy_manage.R;

public class ShopInfoActivity extends BaseActivity {
    private Spinner spinner;
    private ShopEntity shopEntity;
    private EditText master;
    @Override
    protected int initLayout() {
        return R.layout.activity_shop_info;
    }

    @Override
    protected void initView() {
        //下拉选择框
        spinner = findViewById(R.id.spinner_shop_style);
        master = findViewById(R.id.shop_info_master);
        getData();
    }

    @Override
    protected void initData() {
        Intent intent = this.getIntent();
        shopEntity=(ShopEntity)intent.getSerializableExtra("shop");
        master.setText(shopEntity.getName());
    }
    private void getData() {
        //拿到数据
        final String[] arrays = getResources ().getStringArray (R.array.style_name);
        //获取系统自带的适配器
        ArrayAdapter<String> mSpinnerAdapter = new ArrayAdapter<String> (ShopInfoActivity.this,android.R.layout.simple_spinner_dropdown_item,arrays);
        spinner.setAdapter (mSpinnerAdapter);
        //添加点击事件
        spinner.setOnItemLongClickListener (new AdapterView.OnItemLongClickListener () {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText (ShopInfoActivity.this, "哈喽" + arrays[position], Toast.LENGTH_SHORT).show ();
                return false;
            }
        });

    }
}