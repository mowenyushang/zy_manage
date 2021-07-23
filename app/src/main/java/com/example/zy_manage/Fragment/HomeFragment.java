package com.example.zy_manage.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.zy_manage.Activity.OrderActivity;
import com.example.zy_manage.Activity.ShopActivity;
import com.example.zy_manage.Api.ApiConfig;
import com.example.zy_manage.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends BaseFragment {

    Banner banner;
    TextView tvStyle;
    private List<Integer> image = new ArrayList<>();
    private List<String> title = new ArrayList<>();
    ImageButton btn_order,btn_shop;
    String responseData;
    public HomeFragment() {

    }

    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home, container, false);
        banner = view.findViewById(R.id.banner);
        btn_order = view.findViewById(R.id.imgbtn_order);
        btn_shop = view.findViewById(R.id.imgbtn_shop);
        initData();
        initView();
        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateTo(OrderActivity.class);
            }
        });
        btn_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(responseData!=null){
                    Bundle bundle = new Bundle();
                    bundle.putString("Json",responseData);
                    navigateToWithBundle(ShopActivity.class,bundle);
                }else {
                    showToast("请更换到专用网络后再尝试");
                }

            }
        });

        return view;
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
                    responseData = response.body().string();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    @Override
    protected int initLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.setImageLoader(new MyImageLoader());
        banner.setImages(image);
        banner.setBannerAnimation(Transformer.Default);
        banner.isAutoPlay(true);
        banner.setBannerTitles(title);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        banner.setDelayTime(3000);
        banner.setOnBannerListener(this::OnBannerClick);
        banner.start();

    }

    @Override
    protected void initData() {
        image.clear();
        title.clear();
        image.add(R.drawable.lb_four);
        image.add(R.drawable.lb_second);
        image.add(R.drawable.lb_first);
        image.add(R.drawable.lb_three);
        image.add(R.drawable.lb_five);
        title.add("今日营销额");
        title.add("新加入店铺");
        title.add("夏季推荐");
        title.add("衬衫打折");
        title.add("面料上新");
        //请求json数据
        sendRequestWithOkHttp();

    }

    public void OnBannerClick(int position) {
        Toast.makeText(getActivity(), "你点了第" + (position + 1) + "张轮播图", Toast.LENGTH_SHORT).show();
    }


    private class MyImageLoader extends ImageLoader {

        public void displayImage(Context context, Object path, ImageView imageView) {

            Glide.with(context).load(path).into(imageView);

        }
    }

    @Override
    public void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }
}