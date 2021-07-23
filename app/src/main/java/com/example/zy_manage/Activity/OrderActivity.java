package com.example.zy_manage.Activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zy_manage.Api.ApiConfig;
import com.example.zy_manage.Entity.JsonEntity;
import com.example.zy_manage.MainActivity;
import com.example.zy_manage.R;
import com.google.gson.Gson;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OrderActivity extends BaseActivity implements View.OnClickListener {
    private Button btn_request;
    private TextView tv_request;
    List<JsonEntity> shops;
    private Button back;
    @Override
    protected int initLayout() {
        return R.layout.activity_order;
    }

    @Override
    protected void initView() {
        tv_request = findViewById(R.id.tv_test);
        btn_request = findViewById(R.id.btn_test);
        btn_request.setOnClickListener(this);
        back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateTo(MainActivity.class);
                overridePendingTransition(0, 0);//取消跳转动画
                finish();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_test){
            sendRequestWithOkHttp();
        }
    }

    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url(ApiConfig.BASE_URL+"/jeecg-boot/shop/shopInfo/list")
                            .get()
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    showResponse(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void showResponse(String responseData) {
        Gson gson = new Gson();
        JsonEntity jsonEntity = gson.fromJson(responseData, JsonEntity.class);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 在这里进行UI操作，将结果显示到界面上
                tv_request.setText(responseData);
            }
        });
    }



    /*get方法请求网络
    //创建url,表示要访问的网络
    URL url = new URL("http://www.baidu.com");
    //构建访问连接对象
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    //设置访问方式
    conn.setRequestMethod("GET");
    //设置连接超时
    conn.setConnecTimeout(5000);
    //获取返回的字节流
    InputStream inputStream = conn.getInputStream();
    //关闭连接
    conn.disconnect();*/

}