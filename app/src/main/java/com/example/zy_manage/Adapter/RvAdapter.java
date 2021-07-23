package com.example.zy_manage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.zy_manage.Entity.ShopEntity;
import com.example.zy_manage.R;
import com.example.zy_manage.Utils.OnRecyclerItemClickListener;
import java.util.List;


public class RvAdapter extends RecyclerView.Adapter <RvAdapter.MyViewHolder> {
    private Context context;
    private RecyclerView rv;
    private List<ShopEntity> list;
    //声明自定义的监听接口
    private OnRecyclerItemClickListener monItemClickListener;

    //提供set方法供Activity或Fragment调用
    public void setRecyclerItemClickListener(OnRecyclerItemClickListener listener){
        monItemClickListener=listener;
    }


    public RvAdapter(Context context, RecyclerView view, List<ShopEntity> list){
        this.context = context;
        this.rv = view;
        this.list =list;
    }

    public void setData(List<ShopEntity> list){
        if(list == null){
            return;
        }
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shop_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ShopEntity shop = list.get(position);
        holder.master.setText(shop.getName());
        holder.style.setText(shop.getStyleName());
        holder.address.setText(shop.getAddress());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (monItemClickListener!=null){

                    monItemClickListener.onItemClick(position,list);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,style,master,address;
        public MyViewHolder(@NonNull View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.shop_name);
            style = (TextView) view.findViewById(R.id.shop_style);
            master = (TextView) view.findViewById(R.id.shop_master);
            address = (TextView) view.findViewById(R.id.shop_address);

        }

    }
}
